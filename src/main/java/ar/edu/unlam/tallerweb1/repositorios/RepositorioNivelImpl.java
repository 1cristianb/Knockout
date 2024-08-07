package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Nivel;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("repositorioNivel")
public class RepositorioNivelImpl implements RepositorioNivel{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioNivelImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Nivel crearNivel(Integer numeroDeNivel, Integer valorMax) {
        Nivel nivel = new Nivel();
        nivel.setNumero(numeroDeNivel);
        nivel.setValorMax(valorMax);
        nivel.setValorActual(0);
        sessionFactory.getCurrentSession().save(nivel);
        return nivel;
    }

    @Override
    public Nivel traerDatosDelNivel(Integer id) {
        Nivel nivel = (Nivel) sessionFactory.getCurrentSession().createCriteria(Nivel.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
        return nivel;
    }

    @Override
    public void modificar(Nivel nivel){
        sessionFactory.getCurrentSession().update(nivel);

    }

}
