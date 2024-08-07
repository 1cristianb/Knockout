package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Notificaciones;
import ar.edu.unlam.tallerweb1.modelo.Notificar;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioNotificacion")
public class RepositorioNotificacionImpl implements RepositorioNotificacion {
    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioNotificacionImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Notificaciones> traerNotificaciones() {
        return sessionFactory.getCurrentSession().createCriteria(Notificaciones.class).list();
    }

    @Override
    public void guardarPeticionHabilitarUsuario(Usuario usuario) {
        Notificaciones notificacion = new Notificaciones();
        notificacion.setAsunto("Peticion de habilitacion");
        notificacion.setMensaje("El usuario "+usuario.getEmail()+" solicita habilitacion");
        notificacion.setNotificar(Notificar.PARAADMIN);
        notificacion.setUsuario(usuario);
        sessionFactory.getCurrentSession().save(notificacion);
    }

    @Override
    public List<Notificaciones> traerNotificacionesParaAdmin() {
        List<Notificaciones> notificaciones = sessionFactory.getCurrentSession()
                .createCriteria(Notificaciones.class)
                .add(Restrictions.eq("notificar","0"))
                .list();

        return notificaciones;
    }

    @Override
    public void eliminarnotificacion(Integer id) {
        Notificaciones notificacion = (Notificaciones) sessionFactory.getCurrentSession()
                .createCriteria(Notificaciones.class)
                .add(Restrictions.eq("usuario.id",id))
                .uniqueResult();
        sessionFactory.getCurrentSession().delete(notificacion);
    }


}
