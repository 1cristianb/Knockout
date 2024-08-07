package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Billetera;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("repositorioBilletera")
public class RepositorioBilleteraImpl implements RepositorioBilletera{
    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioBilleteraImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Billetera traerDatosBilletera(Usuario user) {
        Billetera billetera = (Billetera) sessionFactory.getCurrentSession().createCriteria(Billetera.class)
                .add(Restrictions.eq("usuario", user))
                .uniqueResult();
        return billetera;
    }

    @Override
    public void agregarBilletera(Usuario usuario) {
        Billetera billetera = new Billetera();
        billetera.setUsuario(usuario);
        billetera.setMonto(10000.00f);
        sessionFactory.getCurrentSession().save(billetera);
    }

    @Override
    public void modificar(Billetera billetera) {
        sessionFactory.getCurrentSession().update(billetera);
    }

    @Override
    public Float restarDinero(Billetera billetera, Float monto) {
        billetera.setMonto(billetera.getMonto() - monto);
        sessionFactory.getCurrentSession().update(billetera);

        return billetera.getMonto();
    }

    @Override
    public void sumarMonto(Billetera billetera, Float monto) {
        billetera.setMonto(billetera.getMonto() + monto);
        sessionFactory.getCurrentSession().update(billetera);
    }
}
