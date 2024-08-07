package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Coleccion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class RepositorioColeccionTest extends SpringTest {

    @Autowired
    RepositorioColeccion repositorioColeccion;

    @Test
    @Transactional
    @Rollback
    public void queSePuedaAgregarUnaColeccion(){

        Coleccion coleccion = new Coleccion();
        Usuario usuario = new Usuario(1,"test@gmail.com","123",true," "," "," ",null,null,true);

        coleccion.setUsuario(usuario);

        session().save(usuario);

        this.repositorioColeccion.creacionDeColeccion(usuario);

        Coleccion coleccionDB = this.repositorioColeccion.traerColeccion(usuario);

        System.out.println(this.repositorioColeccion.traerColeccion(usuario));

        assertEquals(coleccionDB.getUsuario(), coleccion.getUsuario());

    }

    @Test
    @Transactional
    @Rollback
    public void queSePuedaObtenerColecciones(){
        List<Coleccion> coleccionList = new ArrayList<>();
        Coleccion coleccion = new Coleccion();
        Usuario usuario = new Usuario(1,"test@gmail.com","123",true," "," "," ",null,null,true);

        coleccion.setUsuario(usuario);

        Coleccion coleccion2 = new Coleccion();
        Usuario usuario2 = new Usuario(2,"test2@gmail.com","123",true," "," "," ",null,null,true);

        coleccion2.setUsuario(usuario2);

        session().save(usuario);
        session().save(usuario2);

        coleccionList.add(coleccion);
        coleccionList.add(coleccion2);

        this.repositorioColeccion.creacionDeColeccion(usuario);
        this.repositorioColeccion.creacionDeColeccion(usuario2);

        List<Coleccion> coleccions = this.repositorioColeccion.obtenerColecciones();

        assertThat(coleccions).hasSize(2);
        assertEquals(coleccions.size(), coleccionList.size());
    }
}
