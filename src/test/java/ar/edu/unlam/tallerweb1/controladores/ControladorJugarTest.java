
package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Personaje;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.*;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControladorJugarTest {

    ServicioPersonaje servicioPersonaje = mock(ServicioPersonaje.class);
    ServicioColeccion servicioColeccion = mock(ServicioColeccion.class);
    ServicioUsuario servicioUsuario = mock(ServicioUsuario.class);
    ServicioNivel servicioNivel = mock(ServicioNivel.class);
    ServicioBilletera servicioBilletera = mock(ServicioBilletera.class);

    Personaje personaje1=new Personaje(1,"IronMan","Más conocido como Tony Stark, es un multimillonario magnate empresarial, " +
            "filántropo, playboy e ingenioso científico", "ironMan.jpg", 10000F,false,true,true,500,500,null,null);

    Personaje personaje2=new Personaje(3,"IronMan","Más conocido como Tony Stark, es un multimillonario magnate empresarial, " +
            "filántropo, playboy e ingenioso científico", "ironMan.jpg", 10000F,false,true,true,500,500,null,null);

    Personaje personaje3 =new Personaje(5,"Thor","Más conocido como Tony Stark, es un multimillonario magnate empresarial, " +
            "filántropo, playboy e ingenioso científico", "ironMan.jpg", 10000F,false,true,true,600,500,null,null);
//    List<Personaje> listaDePersonajesElegidos = Arrays.asList(personaje1, personaje2, personaje3);

    ControladorJugar controladorJugar = new ControladorJugar(servicioPersonaje,servicioColeccion,servicioUsuario,servicioNivel,servicioBilletera);

    List<Personaje> listaDePersonajesElegidos = new ArrayList<>();



    @Test
    public void testQueEnRoundUnoAtaque(){




//
//
//        Personaje personaje=new Personaje(1,"IronMan","Más conocido como Tony Stark, es un multimillonario magnate empresarial, " +
//                "filántropo, playboy e ingenioso científico", "ironMan.jpg", 10000F,false,true,true,500,500,null,null);
//
//        Personaje boot =new Personaje(2,"Thor","Más conocido como Tony Stark, es un multimillonario magnate empresarial, " +
//                "filántropo, playboy e ingenioso científico", "ironMan.jpg", 10000F,false,true,true,600,500,null,null);
//
//
//        //Cuando servicioPersonaje buscaPorId 1 entonces devuelvo el personaje
//        when(servicioPersonaje.buscarPorId(1)).thenReturn(personaje);
//        when(servicioPersonaje.buscarPorId(2)).thenReturn(boot);
//
//        List<Integer> round1 = new ArrayList<>();
//        round1.add(1);
//        round1.add(2);
//
//        when(servicioPersonaje.rounds(personaje, boot, 0,0)).thenReturn(round1);
//
//        ModelAndView mav = controladorJugar.atacarRoundUno(personajeSeleccionado,personajeBoot,rq);
//
//        assertThat(mav.getViewName()).isEqualTo("resultadoRoundUno");



    }

    @Test
    public void TestQueSeleccionaPersonajesParaJugarEsExitoso(){

        Usuario usuario=new Usuario(1,"prueba@gmail.com","1234",true,"Lionel","Messi","Balon de oro",null,null,true);

         String [] personajesElegidos = {"1","2","3"};
        HttpServletRequest rq = mock(HttpServletRequest.class);
        when(rq.getSession()).thenReturn(mock(HttpSession.class));
        when(rq.getSession().getAttribute("idUsuario")).thenReturn(usuario.getId());

        ModelAndView mav = controladorJugar.seleccionDePersonajeParaJugar(personajesElegidos,rq);

        assertThat(mav.getViewName()).isEqualTo("combate");

    }
}