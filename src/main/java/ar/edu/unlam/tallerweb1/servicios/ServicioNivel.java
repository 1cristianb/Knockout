package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Nivel;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioNivel {

    Nivel crearNivel(Integer numeroDeNivel, Integer valorMax);
    Nivel traerDatosDelNivel(Integer id);
    void modificar(Nivel nivel);

}
