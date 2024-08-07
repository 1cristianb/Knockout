package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorUsuario {

    private ServicioUsuario servicioUsuario;

    @Autowired
    public ControladorUsuario(ServicioUsuario servicioUsuario){
        this.servicioUsuario = servicioUsuario;
    }

    @RequestMapping("/miPerfil")
    private ModelAndView irMiPerfil(HttpServletRequest request){

        Integer usuario_id = (Integer) request.getSession().getAttribute("idUsuario");

        if(usuario_id == null){
            return new ModelAndView("redirect:/login");
        }
//      --------------------------------
        ModelMap model = new ModelMap();
//      --------------------------------
        Usuario usuario = servicioUsuario.buscarPorID(usuario_id);

        model.put("usuario", usuario);

        return new ModelAndView("miPerfil", model);
    }

    @RequestMapping("/irModificarPerfil")
    private ModelAndView irModificarPerfil(HttpServletRequest request){

        Integer usuario_id = (Integer) request.getSession().getAttribute("idUsuario");

        if(usuario_id == null){
            return new ModelAndView("redirect:/login");
        }
//      --------------------------------
        ModelMap model = new ModelMap();
//      --------------------------------
        Usuario usuario = servicioUsuario.buscarPorID(usuario_id);
        model.put("usuario", usuario);

        return new ModelAndView("modificarPerfil", model);

    }
    @RequestMapping("/modificarPerfil")
    private ModelAndView modificar(@RequestParam("password")String nuevaPassword,@RequestParam("passwordActual")String actualPassword, HttpServletRequest request){

        Integer usuario_id = (Integer) request.getSession().getAttribute("idUsuario");

        if(usuario_id == null){
            return new ModelAndView("redirect:/login");
        }
//      --------------------------------
        ModelMap model = new ModelMap();
//      --------------------------------
        Usuario usuario = servicioUsuario.buscarPorID(usuario_id);


        if(!usuario.getPassword().equals(actualPassword)){
            model.put("usuario", usuario);
            model.put("error1", "Password actual incorrecta");
            return new ModelAndView("modificarPerfil", model);
        }
        if (usuario.getPassword().equals(nuevaPassword)){
            model.put("usuario", usuario);
            model.put("error", "La password tiene que ser diferente a la anterior");
            return new ModelAndView("modificarPerfil", model);
        }else {
            usuario.setPassword(nuevaPassword);
            servicioUsuario.modificar(usuario);
            return new ModelAndView("redirect:/login");
        }

    }
}
