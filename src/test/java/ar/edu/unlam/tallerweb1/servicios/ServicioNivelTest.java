package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Nivel;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioBilletera;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioNivel;
import org.junit.Test;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;

import static org.assertj.core.api.Assertions.assertThat;


import static org.mockito.Mockito.when;

public class ServicioNivelTest {

    RepositorioNivel repositorioNivel = mock(RepositorioNivel.class);
    ServicioNivel servicioNivel = new ServicioNivelImpl(repositorioNivel);



   @Test
   public void testQueSePuedaCrearUnNivel(){


       Nivel nivel = new Nivel();
       nivel.setId(1);
       nivel.setNumero(11);
       nivel.setValorMax(10);
       nivel.setValorActual(1);

        when(repositorioNivel.crearNivel(anyInt(),anyInt())).thenReturn(nivel);

        Nivel nivelCreado =  servicioNivel.crearNivel(2,10);


        assertThat(nivelCreado).isNotNull();

   }

   @Test
    public void testQueTraigaDatosDeUnNivel(){

       Nivel nivel = new Nivel();
       nivel.setId(1);
       nivel.setNumero(11);
       nivel.setValorMax(10);
       nivel.setValorActual(1);

//       when(servicioNivel.traerDatosDelNivel(nivel.getId())).thenReturn(nivel);

       when(repositorioNivel.traerDatosDelNivel(anyInt())).thenReturn(nivel);
       Nivel datosNivel = servicioNivel.traerDatosDelNivel(10);

//       assertEquals

       assertThat(datosNivel).isNotNull();
       assertThat(1).isEqualTo(datosNivel.getId());

   }









}
