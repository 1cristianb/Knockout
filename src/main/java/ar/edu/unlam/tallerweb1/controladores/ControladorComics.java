package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Comic;
import ar.edu.unlam.tallerweb1.servicios.ServicioComic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ControladorComics {

    private ServicioComic servicioComic;

    @Autowired
    public ControladorComics(ServicioComic servicioComic){
        this.servicioComic = servicioComic;
    }

    @RequestMapping("/descargarComicMarvel")
    public ModelAndView irADescargarComics(){
//      -------------------------------
        ModelMap model = new ModelMap();
//      -------------------------------
        List<Comic> comics = servicioComic.todosLosComics();
        model.put("comics", comics);

        return new ModelAndView("comics", model);
    }
}
