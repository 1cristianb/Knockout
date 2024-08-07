package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Billetera;
import ar.edu.unlam.tallerweb1.modelo.Rol;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioBilletera;
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

@Controller
public class ControladorTrivia {

    private ServicioBilletera servicioBilletera;
    private ServicioUsuario servicioUsuario;

    @Autowired
    public ControladorTrivia(ServicioBilletera servicioBilletera,ServicioUsuario servicioUsuario) {
        this.servicioBilletera = servicioBilletera;
        this.servicioUsuario=servicioUsuario;
    }
    @RequestMapping( "/inicioTrivia")
    public ModelAndView irATriviaInicio(HttpServletRequest request) {
        //--------------------------------
        Integer usuario_id = (Integer) request.getSession().getAttribute("idUsuario");

        if(usuario_id == null){
            return new ModelAndView("redirect:/login");
        }
        if(request.getSession().getAttribute("rol") == Rol.ADMIN){
            return new ModelAndView("redirect:/inicio");
        }

        return new ModelAndView("inicioTrivia");
    }
    @RequestMapping( "/Trivia")
    public ModelAndView irATrivia(HttpServletRequest request) {
        //--------------------------------
        Integer usuario_id = (Integer) request.getSession().getAttribute("idUsuario");

        if(usuario_id == null){
            return new ModelAndView("redirect:/login");
        }
        if(request.getSession().getAttribute("rol") == Rol.ADMIN){
            return new ModelAndView("redirect:/inicio");
        }

        return new ModelAndView("trivia");
    }

    @RequestMapping( value ="/triviaCheck", method= RequestMethod.GET)
    public ModelAndView resultado(@RequestParam("p")Integer p,HttpServletRequest request) {
        ModelMap model = new ModelMap();
        //--------------------------------
        Integer usuario_id = (Integer) request.getSession().getAttribute("idUsuario");

        if(usuario_id == null){
            return new ModelAndView("redirect:/login");
        }
        if(request.getSession().getAttribute("rol") == Rol.ADMIN){
            return new ModelAndView("redirect:/inicio");
        }

        Float total = Float.valueOf(p*250);
        Usuario usuario = servicioUsuario.buscarPorID(usuario_id);
        Billetera billetera = servicioBilletera.traerDatosBilletera(usuario);

        if(total > 0){
            servicioBilletera.sumarMontoSinDescuento(billetera, total);

            request.getSession().setAttribute("billetera",billetera);
        }


        model.put("puntaje",total);

        return new ModelAndView("triviaCheck",model);
    }
}
