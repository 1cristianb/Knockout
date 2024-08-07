package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorLogout {

    @RequestMapping("/logout")
    public ModelAndView cerrarSesion(HttpServletRequest request){
        request.getSession().invalidate();
        return new ModelAndView("redirect:/login");
    }
}
