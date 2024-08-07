package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Coleccion;
import ar.edu.unlam.tallerweb1.modelo.Personaje;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioColeccion")
public class RepositorioColeccionImpl implements RepositorioColeccion{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioColeccionImpl (SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Coleccion traerColeccion(Usuario user) {
        Coleccion coleccion = (Coleccion) sessionFactory.getCurrentSession().createCriteria(Coleccion.class)
                .add(Restrictions.eq("usuario", user))
                .uniqueResult();
        return coleccion;
    }

    @Override
    public void modificar(Coleccion coleccion) {
        sessionFactory.getCurrentSession().update(coleccion);
    }

    @Override
    public void creacionDeColeccion(Usuario usuario) {
        Coleccion coleccion = new Coleccion();
        coleccion.setUsuario(usuario);
        sessionFactory.getCurrentSession().save(coleccion);
    }

    @Override
    public List<Coleccion> obtenerColecciones() {
        List<Coleccion> colecciones = sessionFactory.getCurrentSession().createCriteria(Coleccion.class)
                .list();
        return colecciones;
    }






/*
*  List <Personaje> personajesEnMiColeccion = sessionFactory.getCurrentSession().createCriteria(Personaje.class)
                .createAlias("coleccion", "c")
                .add(Restrictions.eq("c.id", coleccion.getId()))
                .list();

        return personajesEnMiColeccion;
* */
}
