package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosRegistro;
import ar.edu.unlam.tallerweb1.modelo.Rol;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioNotificacion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service("servicioUsuario")
@Transactional
public class ServicioUsuarioImpl implements ServicioUsuario {

    private RepositorioUsuario repoUsuario;
    private RepositorioNotificacion repositorioNotificacion;

    @Autowired
    public ServicioUsuarioImpl(RepositorioUsuario repoUsuario, RepositorioNotificacion repositorioNotificacion) {
        this.repoUsuario = repoUsuario;
        this.repositorioNotificacion = repositorioNotificacion;
    }

    @Override
    public void registrarUsuario(DatosRegistro datosRegistro) {
        Usuario usuario = new Usuario();
//        usuario.setId(datosRegistro.getId());
        usuario.setNombre(datosRegistro.getNombre());
        usuario.setApellido(datosRegistro.getApellido());
        usuario.setUserName(datosRegistro.getUserName());
        usuario.setEmail(datosRegistro.getEmail());
        usuario.setPassword(datosRegistro.getPassword());
        usuario.setActivo(datosRegistro.getActivo());

        repoUsuario.guardar(usuario);
    }

    @Override
    public Usuario buscarUsuario(String email, String password) {
        return repoUsuario.buscarUsuario(email, password);
    }

    @Override
    public Usuario buscarPorID(Integer id) {
        return repoUsuario.buscarPorID(id);
    }

    @Override
    public void modificar(Usuario usuario) {
        repoUsuario.modificar(usuario);
    }


    @Override
    public Usuario consultarUsuarioPorEmail(String email) {
        return repoUsuario.buscarUsuarioPorEmail(email);
    }


    @Override
    public List<Usuario> getAll() {
        List<Usuario> sinAdmin = new ArrayList<>();
        List<Usuario> usuarios = repoUsuario.getAll();

        for (Usuario lista : usuarios) {
            if (lista.getRol() == Rol.USER) {
                sinAdmin.add(lista);
            }
        }

        return sinAdmin;
    }

    //Ver si se puede ver en el repository
    @Override
    public List<Usuario> rankingJugadores() {
        List<Usuario> jugadores = getAll();
        List<Usuario> rankingJugadores = new ArrayList<>();
        Integer num = 0;

        jugadores.sort(new Comparator<Usuario>() {
            @Override
            public int compare(Usuario o1, Usuario o2) {
                return new Integer(o2.getNivel().getNumero()).compareTo(new Integer(o1.getNivel().getNumero()));
            }
        });

        //Guardar los 3 primeros
        for (Usuario jugador : jugadores) {
            if (num < 3) {
                rankingJugadores.add(jugador);
                num++;
            }
        }

        return rankingJugadores;
    }

    //que obtenga el maximo jugador que esta en el repositorio
    @Override
    public Usuario jugadorConMasNivel() {
        return repoUsuario.jugadorConMasNivel();
    }

    @Override
    public void cambiarEstadoUsuario(Integer id) {
        Usuario usuario = buscarPorID(id);

        if(usuario.getHabilitado()){
            usuario.setHabilitado(false);
        }else{
            usuario.setHabilitado(true);
            repositorioNotificacion.eliminarnotificacion(id);
        }

        repoUsuario.modificar(usuario);
    }

    @Override
    public Usuario buscarUsuarioRolAdmin() {
        return repoUsuario.buscarUsuarioRolAdmin();
    }
    @Override
    public  List<Usuario> buscarLosDemasUsuarios(Integer id){
        List<Usuario>usuarios=getAll();
        Usuario usuarioBuscado=buscarPorID(id);

        for (Usuario user : usuarios) {
            if (user.getId()==usuarioBuscado.getId()) {
                usuarios.remove(usuarioBuscado);
                break;
            }
        }
        return usuarios;
    }

}
