package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.*;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Controller
public class ControladorJugar {
    private ServicioPersonaje servicioPersonaje;
    private ServicioColeccion servicioColeccion;
    private ServicioUsuario servicioUsuario;
    private List<Personaje>misPersonajes;
    private ServicioNivel servicioNivel;
    private ServicioBilletera servicioBilletera;
    private List<Personaje> listaDePersonajesElegidos;


    @Autowired
    public ControladorJugar(ServicioPersonaje servicioPersonaje, ServicioColeccion servicioColeccion,
                            ServicioUsuario servicioUsuario,ServicioNivel servicioNivel, ServicioBilletera servicioBilletera){
        this.servicioPersonaje = servicioPersonaje;
        this.servicioColeccion = servicioColeccion;
        this.servicioUsuario   = servicioUsuario;
        this.servicioNivel     = servicioNivel;
        this.servicioBilletera = servicioBilletera;
    }

    @RequestMapping( "/Jugar")
    public ModelAndView irAJugar(HttpServletRequest request) {
        ModelMap model = new ModelMap();
//      --------------------------------
        Integer usuario_id = (Integer) request.getSession().getAttribute("idUsuario");
        if(usuario_id == null){
            return new ModelAndView("redirect:/login");
        }
        if(request.getSession().getAttribute("rol") == Rol.ADMIN){
            return new ModelAndView("redirect:/inicio");
        }

//      se busca al usuario
        Usuario usuario = servicioUsuario.buscarPorID(usuario_id);

//      traer la coleccion con usuarioID
        Coleccion coleccion = servicioColeccion.traerColeccion(usuario);
//      --------------------------------
        this.misPersonajes = servicioPersonaje.listaDePersonajesEnMiColeccion(coleccion);
//      --------------------------------
        model.put("personajes", this.misPersonajes );

        request.getSession().setAttribute("contadoresPrimerRound", null);
        request.getSession().setAttribute("round1", null);
        request.getSession().setAttribute("personajeUno", null);
        request.getSession().setAttribute("boot1", null);

        request.getSession().setAttribute("contadoresSegundoRound", null);
        request.getSession().setAttribute("round2", null);
        request.getSession().setAttribute("personajeDos", null);
        request.getSession().setAttribute("boot2", null);

        request.getSession().setAttribute("contadoresTercerRound", null);
        request.getSession().setAttribute("round3", null);
        request.getSession().setAttribute("personajeTres", null);
        request.getSession().setAttribute("boot3", null);

        //return new ModelAndView("combate", model);
        return new ModelAndView("seleccionarPersonaje", model);
    }

    @RequestMapping(value = "/seleccionDePersonaje", method= RequestMethod.GET)
    public ModelAndView seleccionDePersonajeParaJugar(@RequestParam("personajesElegidos")String[] personajesElegidos, HttpServletRequest request) {
//      --------------------------------------------------------------
        if(request.getSession().getAttribute("idUsuario") == null){
            return new ModelAndView("redirect:/login");
        }
        if(request.getSession().getAttribute("rol") == Rol.ADMIN){
            return new ModelAndView("redirect:/inicio");
        }
//      --------------------------------
        ModelMap model = new ModelMap();
//      --------------------------------
        if (personajesElegidos.length == 3){

            List<Personaje> listaDePersonajes_Elegidos = new ArrayList<>();

            for (String idPersonaje : personajesElegidos){
                Integer idParseado  = Integer.parseInt(idPersonaje);
                Personaje personaje = servicioPersonaje.buscarPorId(idParseado);
                listaDePersonajes_Elegidos.add(personaje);
            }

            this.listaDePersonajesElegidos = listaDePersonajes_Elegidos;
            model.put("personajes", listaDePersonajesElegidos);

            return new ModelAndView("combate", model);

        } else if (personajesElegidos.length > 3) {
            model.put("error","Se pasó del límite de personajes elegidos.");
            return new ModelAndView("error", model);
        }else {
            model.put("error", "Debe seleccionar <b>TRES</b> personajes.");
        }

        return new ModelAndView("error", model);
    }

    @RequestMapping(value = "/seleccionPersonaje", method= RequestMethod.GET)
    public ModelAndView seleccionPersonajeParaJugar(@RequestParam("id")Integer id, RedirectAttributes atributo) {
//      --------------------------------
        Personaje personajeElegido=servicioPersonaje.buscarPorId(id);
//      --------------------------------
//      se le pasa el personaje buscado al atributo asi se redirige a combate
        atributo.addFlashAttribute(personajeElegido);
//      --------------------------------
        //return new ModelAndView("redirect:/combate");
        return new ModelAndView("redirect:/roundUno");
    }

    @RequestMapping(value = "/seleccionPersonajeRoundDos", method= RequestMethod.GET)
    public ModelAndView seleccionPersonajeRoundDos(@RequestParam("id")Integer id, RedirectAttributes atributo) {
//      --------------------------------
        Personaje personajeElegido = servicioPersonaje.buscarPorId(id);
//      --------------------------------
//      se le pasa el personaje buscado al atributo asi se redirige a combate
        atributo.addFlashAttribute(personajeElegido);
//      --------------------------------
        //return new ModelAndView("redirect:/combate");
        return new ModelAndView("redirect:/roundDos");
    }

    @RequestMapping(value = "/seleccionPersonajeRoundTres", method= RequestMethod.GET)
    public ModelAndView seleccionPersonajeRoundTres(@RequestParam("id")Integer id, RedirectAttributes atributo) {
//      --------------------------------
        Personaje personajeElegido=servicioPersonaje.buscarPorId(id);
//      --------------------------------
//      se le pasa el personaje buscado al atributo asi se redirige a combate
        atributo.addFlashAttribute(personajeElegido);
//      --------------------------------
        //return new ModelAndView("redirect:/combate");
        return new ModelAndView("redirect:/roundTres");
    }

    @RequestMapping("/roundUno")
    public ModelAndView roundUno(@ModelAttribute Personaje personajeElegido) {
//      --------------------------------
        ModelMap model = new ModelMap();
//      --------------------------------
        Personaje personajeBoot  = servicioPersonaje.personajeRandom();
//      ------------------------------------------------------------------
        model.addAttribute("personajeElegido",personajeElegido);
//      ------------------------------------------------------------------
        List<Personaje> todosMenosElSeleccionado = new ArrayList<>();

        for (Personaje p : listaDePersonajesElegidos){
            if (!p.getId().equals(personajeElegido.getId())){
                todosMenosElSeleccionado.add(p);
            }
        }

        model.put("personajes", todosMenosElSeleccionado);
        model.put("personajeBoot", personajeBoot);
//      -------------------------------------------------
        return new ModelAndView("roundUno",model);
    }

    @RequestMapping("/roundDos")
    public ModelAndView roundDos(@ModelAttribute Personaje personajeElegido, HttpServletRequest request) {
//      --------------------------------
        ModelMap model = new ModelMap();
//      --------------------------------
        Personaje personajeBoot  = servicioPersonaje.personajeRandom();
//      ------------------------------------------------------------------
        model.addAttribute("personajeElegido",personajeElegido);
//      ------------------------------------------------------------------
        List<Personaje> todosMenosElSeleccionado = new ArrayList<>();
        Personaje p1 = (Personaje) request.getSession().getAttribute("personajeUno");

        for (Personaje p : listaDePersonajesElegidos){
            if (!p.getId().equals(personajeElegido.getId()) && !p.getId().equals(p1.getId())){
                todosMenosElSeleccionado.add(p);
            }
        }

        Personaje personajeRandom = (Personaje) request.getSession().getAttribute("random1");

        model.put("personajes", todosMenosElSeleccionado);
        model.put("personajeBoot", personajeBoot);
        model.put("personajeRandom", personajeRandom);

        model.put("round1", request.getSession().getAttribute("round1"));
        model.put("p1", request.getSession().getAttribute("personajeUno"));
        model.put("boot1", request.getSession().getAttribute("boot1"));
//      -------------------------------------------------
        return new ModelAndView("roundDos",model);
    }

    @RequestMapping("/roundTres")
    public ModelAndView roundTres(@ModelAttribute Personaje personajeElegido, HttpServletRequest request) {
//      --------------------------------
        ModelMap model = new ModelMap();
//      --------------------------------
        Personaje personajeBoot  = servicioPersonaje.personajeRandom();
//      ------------------------------------------------------------------
        model.addAttribute("personajeElegido",personajeElegido);
//      ------------------------------------------------------------------
        List<Personaje> todosMenosElSeleccionado = new ArrayList<>();
        Personaje p1 = (Personaje) request.getSession().getAttribute("personajeUno");
        Personaje p2 = (Personaje) request.getSession().getAttribute("personajeDos");

        for (Personaje p : listaDePersonajesElegidos){
            if (!p.getId().equals(personajeElegido.getId()) && !p.getId().equals(p1.getId()) && !p.getId().equals(p2.getId())){
                todosMenosElSeleccionado.add(p);
            }
        }

        model.put("personajes", todosMenosElSeleccionado);
        model.put("personajeBoot", personajeBoot);

//      ---------------- Round 1 ---------------------------
        model.put("round1", request.getSession().getAttribute("round1"));
        model.put("p1", request.getSession().getAttribute("personajeUno"));
        model.put("boot1", request.getSession().getAttribute("boot1"));

//      ---------------- Round 2 ---------------------------
        model.put("round2", request.getSession().getAttribute("round2"));
        model.put("p2", request.getSession().getAttribute("personajeDos"));
        model.put("boot2", request.getSession().getAttribute("boot2"));
//      -------------------------------------------------
        return new ModelAndView("roundTres",model);
    }

    @RequestMapping("/combate")
    public ModelAndView combate(@ModelAttribute Personaje personajeElegido) {
//      --------------------------------
        ModelMap model = new ModelMap();
//      --------------------------------
        Personaje personajeBoot  = servicioPersonaje.personajeRandom();
//      ------------------------------------------------------------------
        model.addAttribute("personajeElegido",personajeElegido);
//      ------------------------------------------------------------------
        List<Personaje> todosMenosElSeleccionado = new ArrayList<>();

        for (Personaje p : listaDePersonajesElegidos){
            if (!p.getId().equals(personajeElegido.getId())){
                todosMenosElSeleccionado.add(p);
            }
        }

        model.put("personajes", todosMenosElSeleccionado);
        model.put("personajeBoot", personajeBoot);
//      -------------------------------------------------
        return new ModelAndView("combate",model);
    }

    @RequestMapping("/atacarRoundUno")
    public ModelAndView atacarRoundUno(@RequestParam("personajeSeleccionado") String personajeSeleccionado,
                                       @RequestParam("personajeBoot") String personajeBoot, HttpServletRequest request){
        ModelMap model = new ModelMap();

        Integer idPersonaje = Integer.parseInt(personajeSeleccionado);
        Integer idBoot      = Integer.parseInt(personajeBoot);

        Personaje personajeUno = servicioPersonaje.buscarPorId(idPersonaje);
        Personaje boot1        = servicioPersonaje.buscarPorId(idBoot);

        Integer contadorUsuario = 0;
        Integer contadorBoot    = 0;

        List<Integer> round1 = servicioPersonaje.rounds(personajeUno,boot1,contadorUsuario,contadorBoot);
        contadorUsuario = round1.get(0);
        contadorBoot    = round1.get(1);

        model.put("round1",contadorUsuario + ":" + contadorBoot);
        model.put("p1", personajeUno);
        model.put("boot1", boot1);

        request.getSession().setAttribute("contadoresPrimerRound", round1);
        request.getSession().setAttribute("round1", contadorUsuario + ":" + contadorBoot);
        request.getSession().setAttribute("personajeUno", personajeUno);
        request.getSession().setAttribute("boot1", boot1);

        List<Personaje> todosMenosElSeleccionado = new ArrayList<>();

        for (Personaje p : listaDePersonajesElegidos){
            if (!p.getId().equals(personajeUno.getId())){
                todosMenosElSeleccionado.add(p);
            }
        }

        model.put("personajes", todosMenosElSeleccionado);

        if (contadorBoot > contadorUsuario){
            Personaje personajeRandom = servicioPersonaje.personajeRandom();
            model.put("random1", personajeRandom);
            request.getSession().setAttribute("random1", personajeRandom);
            return new ModelAndView("primeroTiraElBoot", model);
        }

        return new ModelAndView("resultadoRoundUno", model);
    }

    @RequestMapping("/atacarRoundDos")
    public ModelAndView atacarRoundDos(@RequestParam("personajeSeleccionado") String personajeSeleccionado,
                                       @RequestParam("personajeBoot") String personajeBoot, HttpServletRequest request){
        ModelMap model = new ModelMap();

        Integer idPersonaje = Integer.parseInt(personajeSeleccionado);
        Integer idBoot      = Integer.parseInt(personajeBoot);

        Personaje personajeDos = servicioPersonaje.buscarPorId(idPersonaje);
        Personaje boot2        = servicioPersonaje.buscarPorId(idBoot);

        List<Integer> contadoresPrimerRound = (List<Integer>) request.getSession().getAttribute("contadoresPrimerRound");

        Integer contadorUsuario = contadoresPrimerRound.get(0);
        Integer contadorBoot    = contadoresPrimerRound.get(1);

        List<Integer> round2 = servicioPersonaje.rounds(personajeDos,boot2,contadorUsuario,contadorBoot);
        contadorUsuario = round2.get(0);
        contadorBoot    = round2.get(1);

        model.put("round2",contadorUsuario + ":" + contadorBoot);
        model.put("p2", personajeDos);
        model.put("boot2", boot2);

        request.getSession().setAttribute("contadoresSegundoRound", round2);
        request.getSession().setAttribute("round2", contadorUsuario + ":" + contadorBoot);
        request.getSession().setAttribute("personajeDos", personajeDos);
        request.getSession().setAttribute("boot2", boot2);

        List<Personaje> todosMenosElSeleccionado = new ArrayList<>();
        Personaje p1    = (Personaje) request.getSession().getAttribute("personajeUno");
        Personaje boot1 = (Personaje) request.getSession().getAttribute("boot1");

        for (Personaje p : listaDePersonajesElegidos){
            if (!p.getId().equals(personajeDos.getId()) && !p.getId().equals(p1.getId())){
                todosMenosElSeleccionado.add(p);
            }
        }

        model.put("p1", p1);
        model.put("boot1", boot1);
        model.put("personajes", todosMenosElSeleccionado);

        Usuario usuario     = servicioUsuario.buscarPorID((Integer) request.getSession().getAttribute("idUsuario"));
        Nivel nivel         = servicioNivel.traerDatosDelNivel(usuario.getNivel().getId());
        Billetera billetera = servicioBilletera.traerDatosBilletera(usuario);
        String quienGana    = servicioPersonaje.quienGana(contadorUsuario, contadorBoot,billetera,request,nivel,usuario);

        if(quienGana.equals("ganaste")){
            model.put("ganador","<b>¡Ganaste!</b>");
            model.put("monedas","1000");
        }

        if(quienGana.equals("perdiste")){
            model.put("perdedor","<b>Perdiste</b>");
        }

        return new ModelAndView("resultadoRoundDos", model);
    }

    @RequestMapping("/atacarRoundTres")
    public ModelAndView atacarRoundTres(@RequestParam("personajeSeleccionado") String personajeSeleccionado,
                                        @RequestParam("personajeBoot") String personajeBoot, HttpServletRequest request){
        ModelMap model = new ModelMap();

        Integer idPersonaje = Integer.parseInt(personajeSeleccionado);
        Integer idBoot      = Integer.parseInt(personajeBoot);

        Personaje personajeTres = servicioPersonaje.buscarPorId(idPersonaje);
        Personaje boot3         = servicioPersonaje.buscarPorId(idBoot);

        List<Integer> contadoresSegundoRound = (List<Integer>) request.getSession().getAttribute("contadoresSegundoRound");

        Integer contadorUsuario = contadoresSegundoRound.get(0);
        Integer contadorBoot    = contadoresSegundoRound.get(1);

        List<Integer> round3 = servicioPersonaje.rounds(personajeTres,boot3,contadorUsuario,contadorBoot);
        contadorUsuario = round3.get(0);
        contadorBoot    = round3.get(1);

        model.put("round3",contadorUsuario + ":" + contadorBoot);
        model.put("p3", personajeTres);
        model.put("boot3", boot3);

        request.getSession().setAttribute("contadoresTercerRound", round3);
        request.getSession().setAttribute("round3", contadorUsuario + ":" + contadorBoot);
        request.getSession().setAttribute("personajeTres", personajeTres);
        request.getSession().setAttribute("boot3", boot3);

        List<Personaje> todosMenosElSeleccionado = new ArrayList<>();
        Personaje p1    = (Personaje) request.getSession().getAttribute("personajeUno");
        Personaje boot1 = (Personaje) request.getSession().getAttribute("boot1");

        Personaje p2    = (Personaje) request.getSession().getAttribute("personajeDos");
        Personaje boot2 = (Personaje) request.getSession().getAttribute("boot2");

        for (Personaje p : listaDePersonajesElegidos){
            if (!p.getId().equals(personajeTres.getId()) && !p.getId().equals(p1.getId()) && !p.getId().equals(p2.getId())){
                todosMenosElSeleccionado.add(p);
            }
        }

        model.put("p1", p1);
        model.put("boot1", boot1);
        model.put("p2", p2);
        model.put("boot2", boot2);
        model.put("personajes", todosMenosElSeleccionado);

        Usuario usuario     = servicioUsuario.buscarPorID((Integer) request.getSession().getAttribute("idUsuario"));
        Nivel nivel         = servicioNivel.traerDatosDelNivel(usuario.getNivel().getId());
        Billetera billetera = servicioBilletera.traerDatosBilletera(usuario);
        String quienGana    = servicioPersonaje.quienGana(contadorUsuario, contadorBoot,billetera,request,nivel,usuario);

        if(quienGana.equals("ganaste")){
            model.put("ganador","<b>¡Ganaste!</b>");
            model.put("monedas","1000");
        }
        else if(quienGana.equals("empate")){
            model.put("empate","<b>Empate</b>");
            model.put("monedas","500");
        }
        else{
            model.put("perdedor","<b>Perdiste</b>");
        }

        return new ModelAndView("resultadoRoundTres", model);
    }

    @RequestMapping(value = "/verResultados", method= RequestMethod.GET)
    public ModelAndView verResultados(HttpServletRequest request, @RequestParam("personajeUno") String personajeElegidoUno,
                                      @RequestParam("personajeDos") String personajeElegidoDos,
                                      @RequestParam("personajeTres") String personajeElegidoTres,
                                      @RequestParam("personajeBootUno") String personajeBootUno,
                                      @RequestParam("personajeBootDos") String personajeBootDos,
                                      @RequestParam("personajeBootTres") String personajeBootTres){

        if(request.getSession().getAttribute("idUsuario") == null){
            return new ModelAndView("redirect:/login");
        }
        if(request.getSession().getAttribute("rol") == Rol.ADMIN){
            return new ModelAndView("redirect:/inicio");
        }

        ModelMap model = new ModelMap();

        Personaje p1 = servicioPersonaje.buscarPorId(Integer.parseInt(personajeElegidoUno));
        Personaje p2 = servicioPersonaje.buscarPorId(Integer.parseInt(personajeElegidoDos));
        Personaje p3 = servicioPersonaje.buscarPorId(Integer.parseInt(personajeElegidoTres));

        Personaje boot1 = servicioPersonaje.buscarPorId(Integer.parseInt(personajeBootUno));
        Personaje boot2 = servicioPersonaje.buscarPorId(Integer.parseInt(personajeBootDos));
        Personaje boot3 = servicioPersonaje.buscarPorId(Integer.parseInt(personajeBootTres));

        model.put("p1", p1);
        model.put("p2", p2);
        model.put("p3", p3);

        model.put("boot1", boot1);
        model.put("boot2", boot2);
        model.put("boot3", boot3);

        Integer contadorUsuario = 0;
        Integer contadorBoot    = 0;

        List<Integer> round1 = servicioPersonaje.rounds(p1,boot1,contadorUsuario,contadorBoot);
        contadorUsuario = round1.get(0);
        contadorBoot    = round1.get(1);
        model.put("round1",contadorUsuario + ":" + contadorBoot);

        List<Integer> round2 = servicioPersonaje.rounds(p2,boot2,contadorUsuario,contadorBoot);
        contadorUsuario = round2.get(0);
        contadorBoot    = round2.get(1);
        model.put("round2",contadorUsuario + ":" + contadorBoot);

        List<Integer> round3 = servicioPersonaje.rounds(p3,boot3,contadorUsuario,contadorBoot);
        contadorUsuario  = round3.get(0);
        contadorBoot     = round3.get(1);
        model.put("round3",contadorUsuario + ":" + contadorBoot);

        Usuario usuario     = servicioUsuario.buscarPorID((Integer) request.getSession().getAttribute("idUsuario"));
        Nivel nivel         = servicioNivel.traerDatosDelNivel(usuario.getNivel().getId());
        Billetera billetera = servicioBilletera.traerDatosBilletera(usuario);
        String quienGana    = servicioPersonaje.quienGana(contadorUsuario, contadorBoot,billetera,request,nivel,usuario);

        if(quienGana.equals("ganaste")){
            model.put("ganador","<b>¡Ganaste!</b>");
        }
        else if(quienGana.equals("empate")){
            model.put("empate","<b>Empate</b>");
        }
        else{
            model.put("perdedor","<b>Perdiste</b>");
        }

        return new ModelAndView("verResultados",model);
    }


}