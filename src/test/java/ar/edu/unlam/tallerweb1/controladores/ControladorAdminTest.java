package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Personaje;
import ar.edu.unlam.tallerweb1.modelo.Rol;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.*;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControladorAdminTest {

    ServicioPersonaje servicioPersonaje = mock(ServicioPersonaje.class);
    ServicioColeccion servicioColeccion = mock(ServicioColeccion.class);
    ServicioUsuario servicioUsuario = mock(ServicioUsuario.class);
    ServicioNotificacion servicioNotificacion = mock(ServicioNotificacion.class);

    Personaje personaje1=new Personaje(1,"IronMan","Más conocido como Tony Stark, es un multimillonario magnate empresarial, " +
            "filántropo, playboy e ingenioso científico", "ironMan.jpg", 10000F,false,true,true,500,500,null,null);

    Personaje personaje2=new Personaje(3,"IronMan","Más conocido como Tony Stark, es un multimillonario magnate empresarial, " +
            "filántropo, playboy e ingenioso científico", "ironMan.jpg", 10000F,false,true,true,500,500,null,null);

    Personaje personaje3 =new Personaje(5,"Thor","Más conocido como Tony Stark, es un multimillonario magnate empresarial, " +
            "filántropo, playboy e ingenioso científico", "ironMan.jpg", 10000F,false,true,true,600,500,null,null);
    List<Personaje> listaDePersonajesElegidos = Arrays.asList(personaje1, personaje2, personaje3);

    ControladorAdmin controladorAdmin = new ControladorAdmin(servicioUsuario, servicioColeccion, servicioPersonaje, servicioNotificacion);

    @Test
    public void siNoExisteUnaSesion() {
        //Preparacion
        HttpServletRequest request = this.configurarRolLogueado(Rol.USER,null);
        //Ejecucion
        ModelAndView modelAndView = this.controladorAdmin.verHome(request);
        //Verificacion
        assertThat(modelAndView.getViewName()).isEqualTo("redirect:/login");
    }

    @Test
    public void siElRolEsAdminRedirigeALaVistaAdmin() {
        //Preparacion
       HttpServletRequest request = this.configurarRolLogueado(Rol.ADMIN,2);

        //Ejecucion
        ModelAndView modelAndView = this.controladorAdmin.verHome(request);

        //Verificacion
        assertThat(modelAndView.getViewName()).isEqualTo("homeAdmin");
    }

    @Test
    public void siElRolEsUserRedirigeALaVistaAdmin() {
        //Preparacion
        HttpServletRequest request = this.configurarRolLogueado(Rol.USER,1);

        //Ejecucion
        ModelAndView modelAndView = this.controladorAdmin.verHome(request);

        //Verificacion
        assertThat(modelAndView.getViewName()).isEqualTo("redirect:/home");
    }


    private HttpServletRequest configurarRolLogueado(Rol rol, Integer id) {
        HttpServletRequest user = mock(HttpServletRequest.class);
        HttpSession sesionHttp = mock(HttpSession.class);
        when(user.getSession()).thenReturn(sesionHttp);
        when(sesionHttp.getAttribute("rol")).thenReturn(rol);
        when(sesionHttp.getAttribute("idUsuario")).thenReturn(id);

        return user;
    }


}
