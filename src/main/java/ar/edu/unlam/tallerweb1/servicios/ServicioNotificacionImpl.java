package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Notificaciones;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioNotificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("servicioNotificacion")
@Transactional
public class ServicioNotificacionImpl implements ServicioNotificacion {

    private RepositorioNotificacion repoNotificacion;

    @Autowired
    public ServicioNotificacionImpl(RepositorioNotificacion repoNotificacion){
        this.repoNotificacion = repoNotificacion;
    }

    @Override
    public List<Notificaciones> traerNotificaciones() {
        return repoNotificacion.traerNotificaciones();
    }

    @Override
    public void guardarPeticionHabilitarUsuario(Usuario usuario) {
        this.repoNotificacion.guardarPeticionHabilitarUsuario(usuario);
    }

    @Override
    public List<Notificaciones> traerNotificacionesParaAdmin() {
        return this.repoNotificacion.traerNotificacionesParaAdmin();
    }

}
