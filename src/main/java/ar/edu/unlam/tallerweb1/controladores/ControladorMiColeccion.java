package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.ServicioBilletera;
import ar.edu.unlam.tallerweb1.servicios.ServicioColeccion;
import ar.edu.unlam.tallerweb1.servicios.ServicioPersonaje;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Controller
public class ControladorMiColeccion {

    private ServicioPersonaje servicioPersonaje;
    private ServicioColeccion servicioColeccion;
    private ServicioUsuario servicioUsuario;
    private ServicioBilletera servicioBilletera;

    @Autowired
    public ControladorMiColeccion(ServicioPersonaje servicioPersonaje, ServicioColeccion servicioColeccion,
                                  ServicioUsuario servicioUsuario, ServicioBilletera servicioBilletera){
        this.servicioPersonaje = servicioPersonaje;
        this.servicioColeccion = servicioColeccion;
        this.servicioUsuario = servicioUsuario;
        this.servicioBilletera = servicioBilletera;
    }

    @RequestMapping("/miColeccion")
    public ModelAndView irAMiColeccion(HttpServletRequest request) {
        if(request.getSession().getAttribute("idUsuario") == null){
            return new ModelAndView("redirect:/login");
        }
        if(request.getSession().getAttribute("rol") == Rol.ADMIN){
            return new ModelAndView("redirect:/inicio");
        }
//      --------------------------------
        ModelMap model = new ModelMap();
//      --------------------------------
//      MODIFICACIONES A FUTURO:
//          - buscar la coleccion con el id del usuario
//          - mostrar solamente los personajes que están en esa colección

        Integer usuario_id = (Integer) request.getSession().getAttribute("idUsuario");

//      se busca al usuario
        Usuario usuario = servicioUsuario.buscarPorID(usuario_id);

//      traer la coleccion con usuarioID
        Coleccion coleccion = servicioColeccion.traerColeccion(usuario);

        //List <Personaje> listaPersonajes = servicioPersonaje.listaDePersonajesEnMiColeccion(coleccion.getId());
        //List <Personaje> listaPer =    coleccion.getPersonajes();

//      --------------------------------
        List<Personaje> listaPersonajes = servicioPersonaje.listaDePersonajesEnMiColeccion(coleccion);
//      --------------------------------
        model.put("personajes", listaPersonajes);
        model.put("coleccion", coleccion);
//      --------------------------------
        return new ModelAndView("miColeccion", model);
    }

    @RequestMapping("/venderPersonaje")
    public ModelAndView venderPersonajes(@RequestParam("id") Integer id, HttpServletRequest request) {
        ModelMap model = new ModelMap();
        Integer usuario_id = (Integer) request.getSession().getAttribute("idUsuario");

        Usuario usuario = servicioUsuario.buscarPorID(usuario_id);
        Coleccion coleccion = servicioColeccion.traerColeccion(usuario);
        Billetera billetera = servicioBilletera.traerDatosBilletera(usuario);
        List<Personaje> listaPersonajes = servicioPersonaje.listaDePersonajesEnMiColeccion(coleccion);
        Personaje personaje = servicioPersonaje.traerPersonaje(id);
        servicioBilletera.sumarMonto(billetera,personaje.getMonto());
        List<Personaje> nuevaLista = servicioPersonaje.eliminarpersonaje(listaPersonajes,personaje);
        //Servicio billetera limitar a 2 decimales
        billetera.setMonto(servicioBilletera.limitarDecimales(billetera));
        request.getSession().setAttribute("billetera",billetera);

        coleccion.setPersonajes(nuevaLista);

        servicioColeccion.modificar(coleccion);


        return new ModelAndView("redirect:/miColeccion");
    }

    @RequestMapping("/aIntercambiar")
    public ModelAndView aIntercambiar(@RequestParam("id") Integer id, HttpServletRequest request) {
        ModelMap model = new ModelMap();
        Integer usuario_id = (Integer) request.getSession().getAttribute("idUsuario");

//      se busca al usuario
        Usuario usuario = servicioUsuario.buscarPorID(usuario_id);

//      traer la coleccion con usuarioID
        Coleccion coleccion = servicioColeccion.traerColeccion(usuario);

//      --------------------------------
        List<Personaje> listaPersonajes = servicioPersonaje.listaDePersonajesEnMiColeccion(coleccion);

        Personaje personaje = servicioPersonaje.traerPersonaje(id);

        List<Personaje> nuevaLista = servicioPersonaje.modificarPersonajeAIntercambiable(listaPersonajes,personaje);
//      --------------------------------

        coleccion.setPersonajes(nuevaLista);

        servicioColeccion.modificar(coleccion);


        return new ModelAndView("redirect:/miColeccion");
    }
    @RequestMapping("/aColeccion")
    public ModelAndView aColeccion(@RequestParam("id") Integer id, HttpServletRequest request) {
        ModelMap model = new ModelMap();
        Integer usuario_id = (Integer) request.getSession().getAttribute("idUsuario");

//      se busca al usuario
        Usuario usuario = servicioUsuario.buscarPorID(usuario_id);

//      traer la coleccion con usuarioID
        Coleccion coleccion = servicioColeccion.traerColeccion(usuario);

//      --------------------------------
        List<Personaje> listaPersonajes = servicioPersonaje.listaDePersonajesEnMiColeccion(coleccion);

        Personaje personaje = servicioPersonaje.traerPersonaje(id);

        List<Personaje> nuevaLista = servicioPersonaje.modificarPersonajeAColeccion(listaPersonajes,personaje);
//      --------------------------------

        coleccion.setPersonajes(nuevaLista);

        servicioColeccion.modificar(coleccion);


        return new ModelAndView("redirect:/miColeccion");
    }

}
