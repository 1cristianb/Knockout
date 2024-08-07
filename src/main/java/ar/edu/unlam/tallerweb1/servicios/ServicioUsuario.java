package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistro;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

public interface ServicioUsuario {

    void registrarUsuario(DatosRegistro datosRegistro);
    Usuario consultarUsuarioPorEmail(String email);
    Usuario buscarUsuario(String email, String password);
    Usuario buscarPorID(Integer id);
    void modificar(Usuario usuario);
    List<Usuario> getAll();
    List<Usuario> rankingJugadores();
    Usuario jugadorConMasNivel();
    void cambiarEstadoUsuario(Integer id);

    Usuario buscarUsuarioRolAdmin();
    List<Usuario> buscarLosDemasUsuarios(Integer id);
}
