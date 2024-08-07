package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistro;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioBilletera;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioNotificacion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.junit.Test;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import static org.junit.Assert.*;

public class ServicioUsuarioTest {

    RepositorioUsuario repositorioUsuario = mock(RepositorioUsuario.class);
    RepositorioNotificacion repositorioNotificacion = mock(RepositorioNotificacion.class);

    ServicioUsuario servicioUsuario = new ServicioUsuarioImpl(repositorioUsuario,repositorioNotificacion);


    @Test
    public void queSePuedaConsultarPorEmailUnUsuario(){

        Usuario usuario=new Usuario(1,"prueba@gmail.com","1234",true,"Lionel","Messi","Balon de oro",null,null,true);

//        when(servicioUsuario.consultarUsuarioPorEmail("prueba@gmail.com")).thenReturn(usuario);

        when(repositorioUsuario.buscarUsuarioPorEmail(anyString())).thenReturn(usuario);

        assertThat(usuario).isNotNull();
        assertThat("prueba@gmail.com").isEqualTo(usuario.getEmail());

    }

    @Test
    public void testQueBusqueUnUsuarioPorId(){

        Usuario usuario=new Usuario(1,"prueba@gmail.com","1234",true,"Lionel","Messi","Balon de oro",null,null,true);

        when(repositorioUsuario.buscarPorID(anyInt())).thenReturn(usuario);

        assertThat(usuario).isNotNull();
        assertThat(1).isEqualTo(usuario.getId());





    }




}







