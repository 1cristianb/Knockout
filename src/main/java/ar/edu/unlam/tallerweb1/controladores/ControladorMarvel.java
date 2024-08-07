package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Rol;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ControladorMarvel {

    @RequestMapping( "/Marvel")
    public ModelAndView irAMarvel(HttpServletRequest request) {
        ModelMap model = new ModelMap();
        //--------------------------------
        Integer usuario_id = (Integer) request.getSession().getAttribute("idUsuario");

        if(usuario_id == null){
            return new ModelAndView("redirect:/login");
        }
        if(request.getSession().getAttribute("rol") == Rol.ADMIN){
            return new ModelAndView("redirect:/inicio");
        }

        return new ModelAndView("marvel",model );
    }

    @RequestMapping( "/marvelPersonajes")
    public ModelAndView traerPersonajes(HttpServletRequest request) {
        ModelMap model = new ModelMap();
        //--------------------------------
        Integer usuario_id = (Integer) request.getSession().getAttribute("idUsuario");

        if(usuario_id == null){
            return new ModelAndView("redirect:/login");
        }
        if(request.getSession().getAttribute("rol") == Rol.ADMIN){
            return new ModelAndView("redirect:/inicio");
        }

        return new ModelAndView("marvelPersonajes",model );
    }
    @RequestMapping( "/marvelComics")
    public ModelAndView traerComics(HttpServletRequest request) {
        ModelMap model = new ModelMap();
        //--------------------------------
        Integer usuario_id = (Integer) request.getSession().getAttribute("idUsuario");

        if(usuario_id == null){
            return new ModelAndView("redirect:/login");
        }
        if(request.getSession().getAttribute("rol") == Rol.ADMIN){
            return new ModelAndView("redirect:/inicio");
        }

        return new ModelAndView("marvelComics",model );
    }
    @RequestMapping( "/marvelSeries")
    public ModelAndView traerSeries(HttpServletRequest request) {
        ModelMap model = new ModelMap();
        //--------------------------------
        Integer usuario_id = (Integer) request.getSession().getAttribute("idUsuario");

        if(usuario_id == null){
            return new ModelAndView("redirect:/login");
        }
        if(request.getSession().getAttribute("rol") == Rol.ADMIN){
            return new ModelAndView("redirect:/inicio");
        }

        return new ModelAndView("marvelSeries",model );
    }
}
