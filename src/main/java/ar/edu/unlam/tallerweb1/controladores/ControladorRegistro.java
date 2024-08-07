package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.*;
import com.sun.xml.fastinfoset.algorithm.IntEncodingAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class ControladorRegistro {

    private ServicioUsuario servicioUsuario;
    private ServicioPersonaje servicioPersonaje;
    private ServicioColeccion servicioColeccion;
    private ServicioBilletera servicioBilletera;
    private ServicioNivel servicioNivel;
    private ServicioMail servicioMail;

    @Autowired
    public ControladorRegistro(ServicioUsuario servicioUsuario, ServicioPersonaje servicioPersonaje,
                               ServicioColeccion servicioColeccion, ServicioBilletera servicioBilletera,
                               ServicioNivel servicioNivel, ServicioMail servicioMail){
        this.servicioUsuario   = servicioUsuario;
        this.servicioPersonaje = servicioPersonaje;
        this.servicioColeccion = servicioColeccion;
        this.servicioBilletera = servicioBilletera;
        this.servicioNivel     = servicioNivel;
        this.servicioMail      = servicioMail;
    }

    @RequestMapping("registro")
    public ModelAndView irARegistrarse(){
        return new ModelAndView("registro");
    }


    @RequestMapping(path = "/registrarUsuario")
    public ModelAndView registrarUsuario(@ModelAttribute("usuario") DatosRegistro datosRegistro){
//      --------------------------------
        ModelMap model = new ModelMap();
//      --------------------------------
        Usuario usuarioEmail = servicioUsuario.consultarUsuarioPorEmail(datosRegistro.getEmail());
        String md5 = crearMd5(datosRegistro.getEmail());

        if(usuarioEmail==null){
            servicioUsuario.registrarUsuario(datosRegistro);
            servicioMail.enviarMailRegistro(datosRegistro.getEmail());

            Usuario user = servicioUsuario.consultarUsuarioPorEmail(datosRegistro.getEmail());

//          ------ ASIGNACION DE BILLETERA Y COLECCION ---------
            servicioBilletera.agregarBilletera(user);
            servicioColeccion.creacionDeColeccion(user);

//          ------ CREACION Y ASIGNACION DE NIVEL ---------
            Nivel nivel = servicioNivel.crearNivel(1, 10);
            user.setNivel(nivel);


            //------ ASIGNACION DE ROL ---------
            user.setRol(Rol.USER);
            servicioUsuario.modificar(user);


//          ------ ASIGNACION DE PERSONAJES --------------------
            Random preNumRandom = new Random();
            Integer maxId = servicioPersonaje.maxId();

            int numRandom1  = (int) (preNumRandom.nextDouble() * maxId + 1);
            int numRandom2  = (int) (preNumRandom.nextDouble() * maxId + 1);

            Personaje personajeUno = servicioPersonaje.buscarPorId(numRandom1);
            Personaje personajeDos = servicioPersonaje.buscarPorId(numRandom2);

            List <Personaje> listaDePersonajes = new ArrayList<>();
            listaDePersonajes.add(personajeUno);
            listaDePersonajes.add(personajeDos);

            personajeUno.setEnVenta(false);
            personajeDos.setEnVenta(false);

            personajeUno.setEnMiColeccion(true);
            personajeDos.setEnMiColeccion(true);

            servicioPersonaje.modificar(personajeUno);
            servicioPersonaje.modificar(personajeDos);

            Coleccion coleccion = servicioColeccion.traerColeccion(user);

            coleccion.setPersonajes(listaDePersonajes);
            servicioColeccion.modificar(coleccion);


            return new ModelAndView("redirect:/login");
        }
        else{
            model.put("error","No se puede registrar con un email ya registrado");
        }

        return new ModelAndView("registro",model);

    }

    @RequestMapping(path = "/validar-mail", method = RequestMethod.GET)
    public ModelAndView confirmarMail(@RequestParam(value = "email") String email){
        ModelMap model = new ModelMap();

        try{
            servicioMail.verificarMail(email);
        }catch (Exception e){
            model.put("error", "No se pudo verificar el mail");
            return new ModelAndView("registro", model);
        }

        return new ModelAndView("cuenta-verificada");
    }

//    @RequestMapping(path = "/registrarse")
//    public ModelAndView registrarse(@ModelAttribute("usuario") DatosRegistro datosRegistro){
//
//        ModelMap model = new ModelMap();
//        Usuario usuarioRepetido = servicioRegistro.consultarUsuario(datosRegistro.getUsername());
//
//        servicioRegistro.addUsuario(datosRegistro);
//
//        return new ModelAndView("home",model);
//
//    }

    private String crearMd5(String email){
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(email.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while(hashtext.length() < 32){
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e){
            throw new RuntimeException(e);
        }
    }


}
