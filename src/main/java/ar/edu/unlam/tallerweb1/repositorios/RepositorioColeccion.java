package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Coleccion;
import ar.edu.unlam.tallerweb1.modelo.Personaje;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

public interface RepositorioColeccion {

    Coleccion traerColeccion(Usuario user);
    void modificar(Coleccion coleccion);
    void creacionDeColeccion(Usuario usuario);


    List<Coleccion> obtenerColecciones();
}
