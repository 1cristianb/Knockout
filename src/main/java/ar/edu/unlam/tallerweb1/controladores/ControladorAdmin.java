package ar.edu.unlam.tallerweb1.controladores;


import ar.edu.unlam.tallerweb1.modelo.Personaje;
import ar.edu.unlam.tallerweb1.modelo.Rol;
import ar.edu.unlam.tallerweb1.servicios.ServicioColeccion;
import ar.edu.unlam.tallerweb1.servicios.ServicioNotificacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioPersonaje;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
public class ControladorAdmin {

    private ServicioUsuario servicioUsuario;
    private ServicioColeccion servicioColeccion;

    private ServicioPersonaje servicioPersonaje;
    private ServicioNotificacion servicioNotificacion;

    @Autowired
    public ControladorAdmin(ServicioUsuario servicioUsuario,ServicioColeccion servicioColeccion,
                            ServicioPersonaje servicioPersonaje, ServicioNotificacion servicioNotificacion) {
        this.servicioUsuario = servicioUsuario;
        this.servicioColeccion = servicioColeccion;
        this.servicioPersonaje = servicioPersonaje;
        this.servicioNotificacion = servicioNotificacion;
    }

    //VALIDAR ROLES
    @RequestMapping("/inicio")
    public ModelAndView verHome(HttpServletRequest request){
        if(request.getSession().getAttribute("idUsuario") == null){
            return new ModelAndView("redirect:/login");
        }
        if(request.getSession().getAttribute("rol") == Rol.USER){
            return new ModelAndView("redirect:/home");
        }

        ModelMap model =new ModelMap();
        model.put("usuarios",servicioUsuario.getAll());
        model.put("max", servicioUsuario.rankingJugadores());
        model.put("maximo",servicioUsuario.jugadorConMasNivel());
        model.put("notificaciones", servicioNotificacion.traerNotificaciones());
        //coleccion que tiene mas personajes
        model.put("coleccion",servicioColeccion.coleccionConMasPersonajes());

        return new ModelAndView ("homeAdmin",model);
    }

    @RequestMapping("/administracionPersonaje")
    public ModelAndView getAdministracionPersonaje(){
        ModelMap model =new ModelMap();

        model.put("personajes",servicioPersonaje.listaDePersonajes());

        return new ModelAndView ("modificarPersonaje",model);
    }

    //revisar de agregar habilitado/inhabilitado
    //usuario pueda dar de baja su cuenta --borrar todos los datos bbddd

    @RequestMapping(value = "/cambio-estado", method= RequestMethod.GET)
    public ModelAndView cambiarEstado(@RequestParam("id")Integer id) {

        servicioUsuario.cambiarEstadoUsuario(id);

        return new ModelAndView("redirect:/inicio");
    }

    @RequestMapping(value = "/eliminar", method= RequestMethod.POST)
    public ModelAndView eliminarPersonaje(Integer id) {

        servicioPersonaje.eliminarPersonaje(id);

        return new ModelAndView("redirect:/administracionPersonaje");
    }

    @RequestMapping(value = "/modificar", method= RequestMethod.POST)
    public ModelAndView modificarPersonaje(Integer id, Float monto) {

        Personaje personaje = servicioPersonaje.buscarPorId(id);
        personaje.setMonto(monto);
        servicioPersonaje.modificar(personaje);

        return new ModelAndView("redirect:/administracionPersonaje");
    }

    //Control personajes
    //Crear novedades de admin
}