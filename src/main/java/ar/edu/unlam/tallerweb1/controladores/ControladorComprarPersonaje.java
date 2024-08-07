package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.Exceptions.MontoInsuficienteException;
import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.ServicioBilletera;
import ar.edu.unlam.tallerweb1.servicios.ServicioColeccion;
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
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ControladorComprarPersonaje {

    private ServicioPersonaje servicioPersonaje;
    private ServicioUsuario servicioUsuario;
    private ServicioColeccion servicioColeccion;
    private ServicioBilletera servicioBilletera;

    @Autowired
    public ControladorComprarPersonaje(ServicioPersonaje servicioPersonaje, ServicioUsuario servicioUsuario,
                                       ServicioColeccion servicioColeccion, ServicioBilletera servicioBilletera){
        this.servicioPersonaje = servicioPersonaje;
        this.servicioUsuario = servicioUsuario;
        this.servicioColeccion = servicioColeccion;
        this.servicioBilletera = servicioBilletera;
    }

    @RequestMapping("/comprarPersonaje")
    public ModelAndView irAComprarPersonaje(@RequestParam(required = false, defaultValue = "") String order,HttpServletRequest request) {
        if(request.getSession().getAttribute("idUsuario") == null){
            return new ModelAndView("redirect:/login");
        }
        if(request.getSession().getAttribute("rol") == Rol.ADMIN){
            return new ModelAndView("redirect:/inicio");
        }

        ModelMap model = new ModelMap();

        List<Personaje> listaPersonajes = null;

        switch (order) {
            case "min":
                listaPersonajes = servicioPersonaje.personajeOrdenadoMenorPrecio();
                break;
            case "max":
                listaPersonajes = servicioPersonaje.personajeOrdenadoMayorPrecio();
                break;
            case "name":
                listaPersonajes = servicioPersonaje.personajeOrdenadoAlfabeticamente();
                break;
            default:
                listaPersonajes =servicioPersonaje.listaDePersonajesEnVenta();
        }

        model.put("personajes", listaPersonajes);

        return new ModelAndView("comprarPersonaje", model);
    }

    @RequestMapping("/comprar")
    public ModelAndView comprarPersonaje(@RequestParam("id") Integer id, HttpServletRequest request){
        ModelMap model = new ModelMap();

        Integer idUSer = (Integer) request.getSession().getAttribute("idUsuario");

        Usuario usuario = servicioUsuario.buscarPorID(idUSer);

        try {
            Billetera billetera = servicioBilletera.traerDatosBilletera(usuario);
            Coleccion coleccion = servicioColeccion.traerColeccion(usuario);
            List<Personaje> listaPersonajes = servicioPersonaje.listaDePersonajesEnMiColeccion(coleccion);
            Personaje personaje = servicioPersonaje.traerPersonaje(id);
            personaje.setEnVenta(false);
            personaje.setEnMiColeccion(true);
            servicioBilletera.restarDinero(billetera, personaje.getMonto());
            BigDecimal formatNumber = new BigDecimal(billetera.getMonto());
            billetera.setMonto(formatNumber.setScale(2, RoundingMode.HALF_UP).floatValue());

            request.getSession().setAttribute("billetera",billetera);
            listaPersonajes.add(personaje);

            coleccion.setPersonajes(listaPersonajes);

            servicioColeccion.modificar(coleccion);
        } catch (MontoInsuficienteException e) {
            List<Personaje> listaPersonajes = servicioPersonaje.listaDePersonajesEnVenta();
            model.put("personajes", listaPersonajes);
            model.put("error", "No tienes suficiente dinero para comprar este personaje");
            return new ModelAndView("comprarPersonaje", model);
        }

        return new ModelAndView("redirect:/miColeccion");

    }

}