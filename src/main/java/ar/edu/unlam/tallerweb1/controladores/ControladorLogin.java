package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.ServicioBilletera;
import ar.edu.unlam.tallerweb1.servicios.ServicioNivel;
import ar.edu.unlam.tallerweb1.servicios.ServicioNotificacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;


@Controller
public class ControladorLogin {

	// La anotacion @Autowired indica a Spring que se debe utilizar el contructor como mecanismo de inyección de dependencias,
	// es decir, qeue lo parametros del mismo deben ser un bean de spring y el framewrok automaticamente pasa como parametro
	// el bean correspondiente, en este caso, un objeto de una clase que implemente la interface ServicioLogin,
	// dicha clase debe estar anotada como @Service o @Repository y debe estar en un paquete de los indicados en
	// applicationContext.xml
	private ServicioUsuario servicioUsuario;
	private ServicioBilletera servicioBilletera;
	private ServicioNivel servicioNivel;
	private ServicioNotificacion servicioNotificacion;

	@Autowired
	public ControladorLogin(ServicioUsuario servicioUsuario, ServicioBilletera servicioBilletera,
							ServicioNivel servicioNivel, ServicioNotificacion servicioNotificacion) {
		this.servicioUsuario   = servicioUsuario;
		this.servicioBilletera = servicioBilletera;
		this.servicioNivel     = servicioNivel;
		this.servicioNotificacion = servicioNotificacion;
	}

	// Este metodo escucha la URL localhost:8080/NOMBRE_APP/login si la misma es invocada por metodo http GET
	@RequestMapping("/login")
	public ModelAndView irALogin() {

		ModelMap modelo = new ModelMap();
		// Se agrega al modelo un objeto con key 'datosLogin' para que el mismo sea asociado
		// al model attribute del form que esta definido en la vista 'login'
		modelo.put("datosLogin", new DatosLogin());
		// Se va a la vista login (el nombre completo de la lista se resuelve utilizando el view resolver definido en el archivo spring-servlet.xml)
		// y se envian los datos a la misma  dentro del modelo
		return new ModelAndView("login", modelo);
	}

	// Este metodo escucha la URL validar-login siempre y cuando se invoque con metodo http POST
	// El metodo recibe un objeto Usuario el que tiene los datos ingresados en el form correspondiente y se corresponde con el modelAttribute definido en el
	// tag form:form
	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("datosLogin") DatosLogin datosLogin, HttpServletRequest request) {
		ModelMap model = new ModelMap();

		// invoca el metodo consultarUsuario del servicio y hace un redirect a la URL /home, esto es, en lugar de enviar a una vista
		// hace una llamada a otro action a traves de la URL correspondiente a esta
		Usuario usuarioBuscado = servicioUsuario.buscarUsuario(datosLogin.getEmail(), datosLogin.getPassword());

		/*Cambiar logica de la validacion del login
		* Esta mal logica de usuario = null
		* porque deberia retornar usuario no existe,
		* y si existe pero la contraseña es incorrecta
		* o el mail es incorrecto deberia lanzar otro error
		* */
		if( usuarioBuscado == null ){
			model.put("error", "Usuario o contraseña incorrectos");
			return new ModelAndView("login", model);
		}

		if(usuarioBuscado.getActivo() == false){
			model.put("error", "Debe validar su email");
			return new ModelAndView("login", model);
		}

		if(usuarioBuscado.getHabilitado() == false){
			model.put("user", usuarioBuscado);
			model.put("disabled", "Su usuario se encuentra inhabilitado");
			return new ModelAndView("login", model);
		}

		if(usuarioBuscado.getRol() == Rol.USER) {
			Billetera billetera = servicioBilletera.traerDatosBilletera(usuarioBuscado);
			Nivel nivel = servicioNivel.traerDatosDelNivel(usuarioBuscado.getNivel().getId());
			//setear fecha de hoy
			Date fechaActual = new Date();
			usuarioBuscado.setUltimaConexion(fechaActual);

			servicioUsuario.modificar(usuarioBuscado);
//			------ SE GUARDAN DATOS EN LA SESION -------
			request.getSession().setAttribute("usuario", usuarioBuscado);
			request.getSession().setAttribute("idUsuario", usuarioBuscado.getId());
			request.getSession().setAttribute("billetera", billetera);
			request.getSession().setAttribute("nivel", nivel);
			request.getSession().setAttribute("rol", usuarioBuscado.getRol());
//          -----------------------------------------------------------
			return new ModelAndView("home");
		}

		request.getSession().setAttribute("idUsuario", usuarioBuscado.getId());
		request.getSession().setAttribute("rol", usuarioBuscado.getRol());

		return new ModelAndView("redirect:/inicio");
	}

	// Escucha la URL /home por GET, y redirige a una vista.
	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public ModelAndView irAHome(HttpServletRequest request) {
//		-- LLAMAMOS A AL ID DEL USUARIO QUE SE GUARDÓ EN LA SESION CON LA CLAVE QUE LE ASIGNAMOS --
		Integer idUSer = (Integer) request.getSession().getAttribute("idUsuario");
		if (idUSer != null) {
			return new ModelAndView("home");
		}
		else {
			return new ModelAndView("redirect:/login");
		}
	}

	// Escucha la url /, y redirige a la URL /login, es lo mismo que si se invoca la url /login directamente.
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("redirect:/login");
	}


	@RequestMapping(path = "/guardar-peticion", method = RequestMethod.POST)
	public ModelAndView enviarPeticionHabilitarUusuario(String email) {
		ModelMap model = new ModelMap();
		Usuario usuarioBuscado = servicioUsuario.consultarUsuarioPorEmail(email);
		List <Notificaciones> notificaciones = servicioNotificacion.traerNotificaciones();
		for (Notificaciones n : notificaciones) {
			if (n.getUsuario().getId() == usuarioBuscado.getId()) {
				model.put("error", "No puede reenviar varias peticiones de habilitación");
				model.put("datosLogin", new DatosLogin());
				return new ModelAndView("login", model);
			}
		}
		servicioNotificacion.guardarPeticionHabilitarUsuario(usuarioBuscado);
		model.put("NotificacionEnviada", "Se envió una petición de habilitación");
		model.put("datosLogin", new DatosLogin());
		return new ModelAndView("login", model);
	}
}
