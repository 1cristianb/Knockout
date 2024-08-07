package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Billetera;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

public class RepositorioBilleteraTest extends SpringTest {

    @Autowired
    RepositorioBilletera repositorioBilletera;

    @Test
    @Transactional
    @Rollback
    public void queSePuedaTraerDatosDeUnaBilletera(){

        Usuario usuario=new Usuario(1,"prueba@gmail.com","1234",true,"Lionel","Messi","Balon de oro",null,null,true);
        Billetera billetera=new Billetera(1,50000f,usuario);

        session().save(usuario);

        this.repositorioBilletera.traerDatosBilletera(billetera.getUsuario());

        assertThat(billetera.getId()).isNotNull();
        assertThat(billetera.getMonto()).isNotNull();
        assertThat(billetera.getUsuario()).isNotNull();
    }
    @Test
    @Transactional
    @Rollback
    public void queSePuedaAgregarUnaBilletera(){

        Usuario usuario=new Usuario(1,"prueba@gmail.com","1234",true,"Lionel","Messi","Balon de oro",null,null,true);
        Billetera billetera=new Billetera(1,50000f,usuario);

        session().save(usuario);

        this.repositorioBilletera.agregarBilletera(billetera.getUsuario());

        assertThat(billetera.getId()).isNotNull();
        assertThat(billetera.getUsuario()).isNotNull();
    }

    @Test
    @Transactional
    @Rollback
    public void queSePuedaRestarDinero(){

        Usuario usuario=new Usuario(1,"prueba@gmail.com","1234",true,"Lionel","Messi","Balon de oro",null,null,true);
        Billetera billetera=new Billetera(1,200f,usuario);
        Float monto=100f;

        session().save(usuario);

        this.repositorioBilletera.restarDinero(billetera,monto);

        assertThat(billetera.getMonto()).isEqualTo(100f);

    }

    @Test
    @Transactional
    @Rollback
    public void queSePuedaSumarDinero(){

        Usuario usuario=new Usuario(1,"prueba@gmail.com","1234",true,"Lionel","Messi","Balon de oro",null,null,true);
        Billetera billetera=new Billetera(1,200f,usuario);
        Float monto=100f;

        session().save(usuario);

        this.repositorioBilletera.sumarMonto(billetera,monto);

        assertThat(billetera.getMonto()).isEqualTo(300f);

    }
}
