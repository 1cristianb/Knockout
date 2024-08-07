package ar.edu.unlam.tallerweb1.controladores;


import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.ServicioColeccion;
import ar.edu.unlam.tallerweb1.servicios.ServicioPersonaje;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import com.mercadopago.resources.Preference;
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
public class ControladorIntercambio {
    private ServicioPersonaje servicioPersonaje;
    private ServicioColeccion servicioColeccion;
    private ServicioUsuario servicioUsuario;
    private Personaje personajeDelOtroJugador;
    private Personaje personajeMio;

    private Integer idOtroJugadorIntercambio;

    @Autowired
    public ControladorIntercambio(ServicioPersonaje servicioPersonaje, ServicioColeccion servicioColeccion, ServicioUsuario servicioUsuario){
        this.servicioPersonaje = servicioPersonaje;
        this.servicioColeccion = servicioColeccion;
        this.servicioUsuario = servicioUsuario;
    }

    @RequestMapping( "/seleccionJugadorIntercambio")
    public ModelAndView irAIntercambio(HttpServletRequest request) {
        ModelMap model = new ModelMap();
//      --------------------------------
        Integer usuario_id = (Integer) request.getSession().getAttribute("idUsuario");
        if(usuario_id == null){
            return new ModelAndView("redirect:/login");
        }
        if(request.getSession().getAttribute("rol") == Rol.ADMIN){
            return new ModelAndView("redirect:/inicio");
        }
        //Buscamos la lista de todos los jugadores excepto el usuario de la sesion
        List<Usuario> listaUsuarios = servicioUsuario.buscarLosDemasUsuarios(usuario_id);
        model.put("jugadores",listaUsuarios);

        return new ModelAndView("intercambio",model );
    }
    @RequestMapping(value = "/jugadorIntercambio")
    public ModelAndView traerIntercambiableJugador(@RequestParam("id") Integer idJugador){

        ModelMap model = new ModelMap();

        this.idOtroJugadorIntercambio=idJugador;

//  Traigo personajes del usuario a intercambiar   --------------------------------

        Usuario usuario = servicioUsuario.buscarPorID(idJugador);

        Coleccion coleccion = servicioColeccion.traerColeccion(usuario);

        List<Personaje> listaPersonajes = servicioPersonaje.listaDePersonajesEnMiColeccion(coleccion);

       model.put("intercambiables",listaPersonajes);
       model.put("titulo","Personajes del jugador a intercambiar");

        return new ModelAndView("intercambio", model);

    }
    @RequestMapping(value = "/miIntercambio")
    public ModelAndView traerIntercambiableMio(@RequestParam("id") Integer idPersonaje, HttpServletRequest request){

        ModelMap model = new ModelMap();
        this.personajeDelOtroJugador = servicioPersonaje.traerPersonaje(idPersonaje);

//     Traigo personajes del usuario de la sesion --------------------------------

        Integer usuario_id = (Integer) request.getSession().getAttribute("idUsuario");

        Usuario usuarioDelPedido = servicioUsuario.buscarPorID(usuario_id);

        Coleccion coleccionDelPedido = servicioColeccion.traerColeccion(usuarioDelPedido);

        List<Personaje> listaPersonajesDelPedido = servicioPersonaje.listaDePersonajesEnMiColeccion(coleccionDelPedido);

        model.put("misPersonajes",listaPersonajesDelPedido);
        model.put("titulo2","Mis personajes intercambiables");

        return new ModelAndView("intercambio", model);

    }
    @RequestMapping(value = "/intercambioPersonajes")
    public ModelAndView intercambiarPersonajes(@RequestParam("id") Integer idPersonaje){

        ModelMap model = new ModelMap();
        this.personajeMio = servicioPersonaje.traerPersonaje(idPersonaje);

        model.put("miPersonaje",this.personajeMio);
        model.put("otroPersonaje",this.personajeDelOtroJugador);

        return new ModelAndView("intercambioPersonajes", model);

    }
    @RequestMapping(value = "/intercambio")
    public ModelAndView intercambiar(@RequestParam("idMio") Integer idMio,@RequestParam("idOtro") Integer idOtro, HttpServletRequest request){

        ModelMap model = new ModelMap();

       //---MANEJO DEL PERSONAJE DEL OTRO JUGADOR--------------

        Usuario usuario = servicioUsuario.buscarPorID(this.idOtroJugadorIntercambio);
        Coleccion coleccionOtro = servicioColeccion.traerColeccion(usuario);
        List<Personaje> listaPersonajesOtro = servicioPersonaje.listaDePersonajesEnMiColeccion(coleccionOtro);
        Personaje personaje = servicioPersonaje.traerPersonaje(idOtro);
        List<Personaje> nuevaListaOtro = servicioPersonaje.eliminarpersonaje(listaPersonajesOtro,personaje);
        coleccionOtro.setPersonajes(nuevaListaOtro);
        servicioColeccion.modificar(coleccionOtro);
        //---Agregar--
        Coleccion coleccionNuevoOtro = servicioColeccion.traerColeccion(usuario);
        List<Personaje> listaPersonajesNuevoOtro = servicioPersonaje.listaDePersonajesEnMiColeccion(coleccionNuevoOtro);
        Personaje personajeNuevoOtro = servicioPersonaje.traerPersonaje(idMio);
        personajeNuevoOtro.setEnVenta(false);
        personajeNuevoOtro.setEnMiColeccion(true);
        listaPersonajesNuevoOtro.add(personajeNuevoOtro);
        coleccionNuevoOtro.setPersonajes(listaPersonajesNuevoOtro);
        servicioColeccion.modificar(coleccionNuevoOtro);


        //---MANEJO DE MI PERSONAJE--------------

        Integer usuario_id = (Integer) request.getSession().getAttribute("idUsuario");
        Usuario usuarioMio = servicioUsuario.buscarPorID(usuario_id);
        Coleccion coleccionMio = servicioColeccion.traerColeccion(usuarioMio);
        List<Personaje> listaPersonajesMio = servicioPersonaje.listaDePersonajesEnMiColeccion(coleccionMio);
        Personaje personajeMio = servicioPersonaje.traerPersonaje(idMio);
        List<Personaje> nuevaListaMio = servicioPersonaje.eliminarpersonaje(listaPersonajesMio,personajeMio);
        coleccionMio.setPersonajes(nuevaListaMio);
        servicioColeccion.modificar(coleccionMio);
        //---Agregar--
        Coleccion coleccionNuevoMio = servicioColeccion.traerColeccion(usuarioMio);
        List<Personaje> listaPersonajesNuevoMio = servicioPersonaje.listaDePersonajesEnMiColeccion(coleccionNuevoMio);
        Personaje personajeNuevoMio = servicioPersonaje.traerPersonaje(idOtro);
        personajeNuevoMio.setEnVenta(false);
        personajeNuevoMio.setEnMiColeccion(true);
        listaPersonajesNuevoMio.add(personajeNuevoMio);
        coleccionNuevoMio.setPersonajes(listaPersonajesNuevoMio);
        servicioColeccion.modificar(coleccionNuevoMio);

        model.put("exito","El intercambio se realizó con éxito");

        return new ModelAndView("intercambioPersonajes", model);

    }
}
