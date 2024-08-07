package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Nivel;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface RepositorioNivel {

    Nivel crearNivel(Integer numeroDeNivel, Integer valorMax);
    Nivel traerDatosDelNivel(Integer id);
    void modificar(Nivel nivel);
}
