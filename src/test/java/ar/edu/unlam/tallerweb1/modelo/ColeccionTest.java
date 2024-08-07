package ar.edu.unlam.tallerweb1.modelo;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class ColeccionTest {

    @Test
    public void siColeccionNoTieneUnUsuarioNiPersonaje(){

        Coleccion coleccion = new Coleccion();

        assertThat(coleccion).isNotNull();
        assertThat(coleccion.getUsuario()).isNull();
        assertThat(coleccion.getPersonajes()).isNull();

    }

    @Test
    public void crearColeccion(){
        Usuario usuario = new Usuario(1,"test@gmail.com","123",true,"Test","Test","Test",null,null,true);

        Personaje personaje1=new Personaje(1,"IronMan","Más conocido como Tony Stark, es un multimillonario magnate empresarial, " +
                "filántropo, playboy e ingenioso científico", "ironMan.jpg", 10000F,false,true,true,500,500,null,null);

        Personaje personaje2=new Personaje(3,"IronMan","Más conocido como Tony Stark, es un multimillonario magnate empresarial, " +
                "filántropo, playboy e ingenioso científico", "ironMan.jpg", 10000F,false,true,true,500,500,null,null);

        Personaje personaje3 =new Personaje(5,"Thor","Más conocido como Tony Stark, es un multimillonario magnate empresarial, " +
                "filántropo, playboy e ingenioso científico", "ironMan.jpg", 10000F,false,true,true,600,500,null,null);

        List<Personaje> listaDePersonajes = Arrays.asList(personaje1, personaje2, personaje3);

        Coleccion coleccion = new Coleccion(1,usuario,listaDePersonajes);

        assertThat(coleccion).isNotNull();

    }

    @Test
    public void siColeccionTienePersonajes(){
        Usuario usuario = new Usuario(1,"test@gmail.com","123",true,"Test","Test","Test",null,null,true);

        Personaje personaje1=new Personaje(1,"IronMan","Más conocido como Tony Stark, es un multimillonario magnate empresarial, " +
                "filántropo, playboy e ingenioso científico", "ironMan.jpg", 10000F,false,true,true,500,500,null,null);

        Personaje personaje2=new Personaje(3,"IronMan","Más conocido como Tony Stark, es un multimillonario magnate empresarial, " +
                "filántropo, playboy e ingenioso científico", "ironMan.jpg", 10000F,false,true,true,500,500,null,null);

        Personaje personaje3 =new Personaje(5,"Thor","Más conocido como Tony Stark, es un multimillonario magnate empresarial, " +
                "filántropo, playboy e ingenioso científico", "ironMan.jpg", 10000F,false,true,true,600,500,null,null);

        List<Personaje> listaDePersonajes = Arrays.asList(personaje1, personaje2, personaje3);

        Coleccion coleccion = new Coleccion(1,usuario,listaDePersonajes);

        assertThat(coleccion).isNotNull();
        assertThat(coleccion.getPersonajes()).isNotNull();
        assertThat(coleccion.getPersonajes()).hasSize(3);

    }

    @Test
    public void siColeccionTieneUnUsuario(){
        Usuario usuario = new Usuario(1,"test@gmail.com","123",true,"Test","Test","Test",null,null,true);

        Personaje personaje1=new Personaje(1,"IronMan","Más conocido como Tony Stark, es un multimillonario magnate empresarial, " +
                "filántropo, playboy e ingenioso científico", "ironMan.jpg", 10000F,false,true,true,500,500,null,null);

        Personaje personaje2=new Personaje(3,"IronMan","Más conocido como Tony Stark, es un multimillonario magnate empresarial, " +
                "filántropo, playboy e ingenioso científico", "ironMan.jpg", 10000F,false,true,true,500,500,null,null);

        Personaje personaje3 =new Personaje(5,"Thor","Más conocido como Tony Stark, es un multimillonario magnate empresarial, " +
                "filántropo, playboy e ingenioso científico", "ironMan.jpg", 10000F,false,true,true,600,500,null,null);

        List<Personaje> listaDePersonajes = Arrays.asList(personaje1, personaje2, personaje3);

        Coleccion coleccion = new Coleccion(1,usuario,listaDePersonajes);

        assertThat(coleccion).isNotNull();
        assertEquals(coleccion.getUsuario().getEmail(), usuario.getEmail());

    }

}
