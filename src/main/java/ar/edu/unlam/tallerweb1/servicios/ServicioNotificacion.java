package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Notificaciones;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

public interface ServicioNotificacion {
    List<Notificaciones> traerNotificaciones();

    void guardarPeticionHabilitarUsuario(Usuario usuario);

    List<Notificaciones> traerNotificacionesParaAdmin();
}
