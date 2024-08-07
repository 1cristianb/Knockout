package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Notificaciones;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

public interface RepositorioNotificacion {
    List<Notificaciones> traerNotificaciones();

    void guardarPeticionHabilitarUsuario(Usuario usuario);

    List<Notificaciones> traerNotificacionesParaAdmin();

    void eliminarnotificacion(Integer id);
}
