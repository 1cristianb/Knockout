package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ServicioPersonaje {

    List<Personaje> listaDePersonajes();
    List<Personaje> listaDePersonajesEnVenta();
    List<Personaje> listaDePersonajesEnMiColeccion();
    Personaje buscarPorId(Integer id);
    public Integer maxId();
    void modificar(Personaje personaje);
    List<Personaje> listaDePersonajesEnMiColeccion(Coleccion coleccion);

    Personaje traerPersonaje(Integer id);

    List<Personaje> eliminarpersonaje(List<Personaje> listaPersonajes, Personaje personaje);

    void eliminarPersonaje(Integer id);
    List<Personaje> modificarPersonajeAIntercambiable(List<Personaje> listaPersonajes, Personaje personaje);
    List<Personaje> modificarPersonajeAColeccion(List<Personaje> listaPersonajes, Personaje personaje);
    List<Personaje> personajeOrdenadoMenorPrecio();

    List<Personaje> personajeOrdenadoMayorPrecio();

    List<Personaje> personajeOrdenadoAlfabeticamente();

    List<Integer> rounds(Personaje personaje, Personaje boot, Integer contadorUsuario, Integer contadorBoot);

    String quienGana(Integer contadorUsuario, Integer contadorBoot, Billetera billetera, HttpServletRequest request,
                     Nivel nivel, Usuario usuario);

    Personaje personajeRandom();

}
