package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Coleccion;
import ar.edu.unlam.tallerweb1.modelo.Personaje;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioColeccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("servicioColeccion")
@Transactional
public class ServicioColeccionImpl implements ServicioColeccion{

    private ServicioPersonaje servicioPersonaje;
    private RepositorioColeccion repoColeccion;

    @Autowired
    public ServicioColeccionImpl(ServicioPersonaje servicioPersonaje,RepositorioColeccion repoColeccion){
        this.servicioPersonaje = servicioPersonaje;
        this.repoColeccion = repoColeccion;
    }

    @Override
    public Coleccion traerColeccion(Usuario user) {
        return repoColeccion.traerColeccion(user);
    }

    @Override
    public void modificar(Coleccion coleccion){
        repoColeccion.modificar(coleccion);
    }

    @Override
    public void creacionDeColeccion(Usuario usuario) {
        repoColeccion.creacionDeColeccion(usuario);
    }

    @Override
    public Coleccion coleccionConMasPersonajes() {
        List<Coleccion> colecciones = repoColeccion.obtenerColecciones();

        Coleccion coleccionConMasPersonajes = null;


        for (Coleccion coleccion : colecciones) {
            if (coleccionConMasPersonajes == null) {
                coleccionConMasPersonajes = coleccion;
            } else {
                if (coleccionConMasPersonajes.getPersonajes().size() < coleccion.getPersonajes().size()) {
                        coleccionConMasPersonajes = coleccion;
                    }
                }
            }

        return coleccionConMasPersonajes;

    }


}
