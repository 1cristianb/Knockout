package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Personaje;
import ar.edu.unlam.tallerweb1.modelo.Rol;
import ar.edu.unlam.tallerweb1.servicios.ServicioPersonaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorVerMasPersonaje {
    private ServicioPersonaje servicioPersonaje;

    @Autowired
    public ControladorVerMasPersonaje(ServicioPersonaje servicioPersonaje){
        this.servicioPersonaje = servicioPersonaje;
    }

    @RequestMapping(value = "/verMasPersonaje", method= RequestMethod.GET)
    public ModelAndView verDescripcionPersonaje(@RequestParam("id")Integer id, HttpServletRequest request) {
//      --------------------------------
        ModelMap model = new ModelMap();
//      --------------------------------

        if(request.getSession().getAttribute("idUsuario") == null){
            return new ModelAndView("redirect:/login");
        }
        if(request.getSession().getAttribute("rol") == Rol.ADMIN){
            return new ModelAndView("redirect:/inicio");
        }

        Personaje personaje=servicioPersonaje.buscarPorId(id);
//      --------------------------------
        model.put("personaje", personaje);
//      --------------------------------
        return new ModelAndView("descripcionPersonaje", model);
    }
}
