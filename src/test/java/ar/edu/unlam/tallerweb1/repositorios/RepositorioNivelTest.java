package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Nivel;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.Assert.*;

public class RepositorioNivelTest extends SpringTest {

    @Autowired
    RepositorioNivel repositorioNivel;

    @Test
    @Transactional
    @Rollback
    public void testQueCreeUnNIvel(){

       Nivel nivelCreado = repositorioNivel.crearNivel(1,10);
       assertNotNull(nivelCreado);
       assertThat(nivelCreado).isNotNull();
       assertThat(nivelCreado.getNumero()).isEqualTo(1);


    }

    @Test
    @Transactional
    @Rollback
    public void testQueMetraigaDatosDeUnNivel(){

        Nivel nivel = new Nivel();
        nivel.setId(1);
        nivel.setValorActual(2);
        nivel.setValorMax(10);
        nivel.setNumero(1);
        session().save(nivel);


        Nivel datosNivel = repositorioNivel.traerDatosDelNivel(1);
        Nivel datosNivelErroneo = repositorioNivel.traerDatosDelNivel(10);

        assertNotNull(datosNivel);
        assertNull(datosNivelErroneo);


    }

}
