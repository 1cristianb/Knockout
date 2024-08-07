package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Coleccion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioColeccion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ServicioColeccionTest {

    RepositorioColeccion repositorioColeccion = mock(RepositorioColeccion.class);
    ServicioPersonaje servicioPersonaje = mock(ServicioPersonaje.class);
    RepositorioUsuario repositorioUsuario = mock(RepositorioUsuario.class);

    ServicioColeccion servicioColeccion =new ServicioColeccionImpl(servicioPersonaje,repositorioColeccion);


    @Test
    public void NoTieneColeccion() {
        //Preparacion
        givenNoExisteUnaColeccion();

        //Ejecucion
        Usuario usuario = new Usuario(1,"test@gmail.com","123",true,"Test","Test","Test",null,null,true);
        Coleccion coleccion = whenTraeDatosDeColeccion(usuario);

        //Verificacion
        thenNoTraerDatosDeColeccion(coleccion);
    }

    @Test
    public void tieneColeccion() {
        //Preparacion
        Usuario user = givenExisteUnaColeccion();

        //Ejecucion
        Coleccion coleccion = whenTraeDatosDeColeccionBD(user);

        //Verificacion
        thenTraerDatosDeColeccion(coleccion);
    }

    @Test
    public void noSePuedeCrearColeccion(){
        //Preparacion
        givenNoExisteUnaColeccion();

        //Ejecucion
        Usuario usuario = new Usuario(1,"test@gmail.com","123",true,"Test","Test","Test",null,null,true);
        Coleccion coleccion = whenNoSePuedeCrearColeccion(usuario);

        //Verificacion
        thenCrearColeccion(coleccion);
    }

    @Test
    public void obtenerColecciones(){
        //Preparacion
        Usuario usuario = givenExisteUnaColeccion();
        List<Coleccion> coleccions = new ArrayList<Coleccion>();
        Coleccion coleccion = new Coleccion();
        coleccion.setUsuario(usuario);
        coleccions.add(coleccion);

        //Ejecucion
        when(this.repositorioColeccion.obtenerColecciones()).thenReturn(coleccions);
        servicioColeccion.creacionDeColeccion(usuario);
        List<Coleccion> coleccionList = whenObtenerColecciones();

        verify(this.repositorioColeccion).obtenerColecciones();

        assertThat(coleccionList).hasSize(1);

    }

    //Preparacion
    private Usuario givenExisteUnaColeccion() {
        Usuario usuario = new Usuario();
        usuario.setEmail("pepito@gmail.com");
        usuario.setPassword("123");
        when(repositorioUsuario.buscarUsuario(usuario.getEmail(),usuario.getPassword())).thenReturn(usuario);
        return usuario;
    }
    private void givenNoExisteUnaColeccion() {
    }

    //Ejecucion
    private Coleccion whenTraeDatosDeColeccion(Usuario usuario) {
        return servicioColeccion.traerColeccion(usuario);
    }
    private Coleccion whenTraeDatosDeColeccionBD(Usuario usuario) {
        Coleccion coleccion = new Coleccion();
        coleccion.setUsuario(usuario);
        when(repositorioColeccion.traerColeccion(usuario)).thenReturn(coleccion);
        return coleccion;
    }

    public List<Coleccion> whenObtenerColecciones(){
        List<Coleccion> colecciones = repositorioColeccion.obtenerColecciones();
        return colecciones;
    }

    private Coleccion whenNoSePuedeCrearColeccion(Usuario usuario) {
        if(repositorioColeccion.traerColeccion(usuario) == null){
            return null;
        }
        return servicioColeccion.traerColeccion(usuario);
    }

    //Verificacion
    private void thenNoTraerDatosDeColeccion(Coleccion coleccion) {
        assertThat(coleccion).isNull();
    }

    private void thenTraerDatosDeColeccion(Coleccion coleccion) {
        assertThat(coleccion).isNotNull();
    }

    private void thenCrearColeccion(Coleccion coleccion) {
        assertThat(coleccion).isNull();
    }
}