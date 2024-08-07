package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Coleccion;
import ar.edu.unlam.tallerweb1.modelo.Personaje;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioColeccion;
import ar.edu.unlam.tallerweb1.servicios.ServicioPersonaje;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControladorIntercambioTest {

    ServicioPersonaje servicioPersonaje=mock(ServicioPersonaje.class);
    ServicioUsuario servicioUsuario=mock(ServicioUsuario.class);
    ServicioColeccion servicioColeccion=mock(ServicioColeccion.class);

    ControladorIntercambio controladorIntercambio=new ControladorIntercambio(servicioPersonaje, servicioColeccion,servicioUsuario);


    @Test
    public void queSePuedaTraerPersonajesIntercambiablesDeUnJugadorConExito()  {

        //Preparación => given

        givenPersonajesIntercambiables();

        // Ejecución => when
        Usuario usuario=new Usuario(1,"prueba@gmail.com","1234",true,"Lionel","Messi","Balon de oro",null,null,true);

        ModelAndView mav= whenTraerPersonajesIntercambiablesDeUnJugador(usuario.getId());

        //Comprobación =>then

        thenTraerPersonajesIntercambiablesDeUnJugadorExitoso(mav);
    }
    @Test
    public void queSeMuestreParaIntercambiarPersoanjesConExito()  {

        //Preparación => given

        givenPersonajesIntercambiables();

        // Ejecución => when
        Personaje personaje=new Personaje(1,"IronMan","Más conocido como Tony Stark, es un multimillonario magnate empresarial, " +
                "filántropo, playboy e ingenioso científico", "ironMan.jpg", 10000F,false,true,true,500,500,null,null);
        ModelAndView mav= whenSeMuestreParaIntercambiarPersoanjes(personaje.getId());

        //Comprobación =>then

        thenSeMuestreParaIntercambiarPersoanjesConExito(mav);
    }
    //--3º TEST---------------------------------------------------------------------------------------------
    private ModelAndView whenSeIntercambienLosPersonajes(Integer idMio,Integer idOtro,Usuario usuario) {

        HttpServletRequest rq = mock(HttpServletRequest.class);
        when(rq.getSession()).thenReturn(mock(HttpSession.class));
        when(rq.getSession().getAttribute("idUsuario")).thenReturn(usuario.getId());

        return controladorIntercambio.intercambiar(idMio,idOtro,rq);
    }
    private void thenIntercambioDePersonajesExito(ModelAndView mav) {
        assertThat(mav.getModel().get("exito")).isEqualTo("El intercambio se realizó con éxito");
        assertThat(mav.getViewName()).isEqualTo("intercambioPersonajes");
    }

    //--2º TEST---------------------------------------------------------------------------------------------

    private ModelAndView whenSeMuestreParaIntercambiarPersoanjes(Integer idPersonaje) {

        return controladorIntercambio.intercambiarPersonajes(idPersonaje);
    }

    private void thenSeMuestreParaIntercambiarPersoanjesConExito(ModelAndView mav) {
        assertThat(mav.getViewName()).isEqualTo("intercambioPersonajes");
    }

    //--1º TEST---------------------------------------------------------------------------------------------

    private void givenPersonajesIntercambiables() {

    }
    private ModelAndView whenTraerPersonajesIntercambiablesDeUnJugador(Integer idJugador) {

        return controladorIntercambio.traerIntercambiableJugador(idJugador);
    }

    private void thenTraerPersonajesIntercambiablesDeUnJugadorExitoso(ModelAndView mav) {

        assertThat(mav.getViewName()).isEqualTo("intercambio");
    }
    //-----------------------------------------------------------------------------------------------
}

