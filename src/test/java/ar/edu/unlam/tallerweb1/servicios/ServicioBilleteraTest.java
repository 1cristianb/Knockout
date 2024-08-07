package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.Exceptions.MontoInsuficienteException;
import ar.edu.unlam.tallerweb1.modelo.Billetera;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioBilletera;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioBilleteraTest {

    RepositorioBilletera repositorioBilletera=mock(RepositorioBilletera.class);

    ServicioBilletera servicioBilletera=new ServicioBilleteraImpl(repositorioBilletera);

    @Test
    public void siNoExisteBilleteraQueNoSePuedaTraerDatos(){

        //Preparacion
        givenNoExisteBilletera();

        //Ejecucion
        Usuario usuario=new Usuario(1,"prueba@gmail.com","1234",true,"Lionel","Messi","Balon de oro",null,null,true);

       Billetera billeteraDevuelta = whenTraeDatos(usuario);
        //Comprobacion
        thenNoTraeDatosBilletera(billeteraDevuelta);

    }
    @Test
    public void queSePuedaAgregarUnaBilletera(){

        //Preparacion
        givenNoExisteBilletera();

        //Ejecucion
        Usuario usuario=new Usuario(1,"prueba@gmail.com","1234",true,"Lionel","Messi","Balon de oro",null,null,true);
        Billetera billetera=new Billetera(1,5000f,usuario);
         whenAgregarBilletera(usuario);
        //Comprobacion
        thenAgregarBilleteraExitoso(billetera);

    }

    @Test(expected = MontoInsuficienteException.class)
    public void queNoSePuedaRestarDinero(){

        //Preparacion
        givenExisteBilletera();

        //Ejecucion
        Usuario usuario=new Usuario(1,"prueba@gmail.com","1234",true,"Lionel","Messi","Balon de oro",null,null,true);
        Billetera billetera=new Billetera(1,100f,usuario);
        Float montoARestar=150f;

        whenRestarDinero(billetera,montoARestar);

        //Comprobacion

        thenQueNoSePuedaRestarDinero(billetera);

    }
    @Test
    public void queSePuedaSumarMonto(){

        //Preparacion
        givenExisteBilletera();

        //Ejecucion
        Usuario usuario=new Usuario(1,"prueba@gmail.com","1234",true,"Lionel","Messi","Balon de oro",null,null,true);
        Billetera billetera=new Billetera(1,100f,usuario);
        Float montoASumar=150f ;

        whenSumarMonto(billetera,montoASumar);

        //Comprobacion

        thenQueSePuedaSumarMontoExitoso(billetera,montoASumar);

    }
    @Test
    public void queSePuedaAgregarPorcentajes(){

        //Preparacion
        givenExisteBilletera();

        //Ejecucion
        Usuario usuario=new Usuario(1,"prueba@gmail.com","1234",true,"Lionel","Messi","Balon de oro",null,null,true);
        Billetera billetera=new Billetera(1,1000f,usuario);
        Float monto=100f;


        Double montoDevuelto=whenAgregarPorcentajes(Double.valueOf(monto));

        //Comprobacion

        thenQueSePuedaAgregarPorcentajes(montoDevuelto);

    }

    private Double whenAgregarPorcentajes(Double monto) {
       return servicioBilletera.agregarPorcentajes(monto);
    }

    private void thenQueSePuedaAgregarPorcentajes(Double montoDevuelto) {
        assertThat(montoDevuelto).isEqualTo(125.0);
    }

    //----------4º TEST---------------------------------
    private void thenQueSePuedaSumarMontoExitoso(Billetera billetera,Float monto) {
        assertThat(billetera.getMonto()+monto).isEqualTo(billetera.getMonto()+monto);
    }

    private void whenSumarMonto(Billetera billetera, Float monto) {
        servicioBilletera.sumarMonto(billetera,monto);
    }

    //----------3º TEST---------------------------------
    private void thenQueNoSePuedaRestarDinero(Billetera billetera) {
    }

    private void whenRestarDinero(Billetera billetera,Float monto) {
        servicioBilletera.restarDinero(billetera,monto);
    }

    private void givenExisteBilletera() {
    }
    //----------2º TEST---------------------------------

    private void whenAgregarBilletera(Usuario usuario) {
        servicioBilletera.agregarBilletera(usuario);
    }
    private void thenAgregarBilleteraExitoso(Billetera billetera) {
        assertThat(billetera).isNotNull();
    }


    //----------1º TEST---------------------------------
    private void givenNoExisteBilletera() {

    }
    private Billetera whenTraeDatos(Usuario usuario) {
       return servicioBilletera.traerDatosBilletera(usuario);
    }

    private void thenNoTraeDatosBilletera(Billetera billetera) {

        assertThat(billetera).isNull();
    }


}
