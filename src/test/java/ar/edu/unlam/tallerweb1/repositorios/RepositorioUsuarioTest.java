package ar.edu.unlam.tallerweb1.repositorios;


import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.Assert.*;

public class RepositorioUsuarioTest extends SpringTest {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Test
    @Transactional
    @Rollback
    public void testQueBuscarUnUsuarioPorEmail(){

        Usuario usuario = new Usuario();
        usuario.setEmail("lea@gmail.com");
        usuario.setPassword("1234");
        usuario.setActivo(true);
        usuario.setNombre("Leandro");
        usuario.setApellido("Martinez");
        usuario.setUserName("Leashaila");

        Usuario usuario2 = new Usuario();
        usuario2.setEmail("mail@mail.com");
        usuario2.setPassword("1234");
        usuario2.setActivo(true);
        usuario2.setNombre("Levi");
        usuario2.setApellido("Ackerman");
        usuario2.setUserName("LeviAckerman");

        session().save(usuario);
        session().save(usuario2);

        Usuario buscado = repositorioUsuario.buscar("lea@gmail.com");
        Usuario buscado2 = repositorioUsuario.buscar("lea@gmail.com");
        Usuario buscado3 = repositorioUsuario.buscar("leeea@gmail.com");

        assertThat(buscado).isNotNull();
        assertThat(buscado2).isNotNull();
        assertNull(buscado3);



    }




}
