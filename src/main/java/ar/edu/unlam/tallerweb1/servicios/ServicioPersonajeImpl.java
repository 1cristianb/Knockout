package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service("servicioPersonaje")
@Transactional
public class ServicioPersonajeImpl implements ServicioPersonaje {

    private RepositorioPersonaje repoPersonaje;
    private RepositorioColeccion repoColeccion;
    private RepositorioBilletera repoBilletera;
    private RepositorioUsuario repoUsuario;
    private RepositorioNivel repoNivel;

    @Autowired
    public ServicioPersonajeImpl(RepositorioPersonaje repoPersonaje, RepositorioColeccion repoColeccion,RepositorioBilletera repoBilletera,
                                 RepositorioUsuario repoUsuario,RepositorioNivel repoNivel) {
        this.repoPersonaje = repoPersonaje;
        this.repoColeccion = repoColeccion;
        this.repoBilletera = repoBilletera;
        this.repoUsuario   = repoUsuario;
        this.repoNivel     = repoNivel;
    }

    @Override
    public List<Personaje> listaDePersonajes() {
        return repoPersonaje.listaDePersonajes();
    }

    @Override
    public List<Personaje> listaDePersonajesEnVenta() {
        return repoPersonaje.listaDePersonajesEnVenta();
    }

    @Override
    public List<Personaje> listaDePersonajesEnMiColeccion() {
        return repoPersonaje.listaDePersonajesEnMiColeccion();
    }

    @Override
    public Personaje buscarPorId(Integer id) {
        return repoPersonaje.buscarPorId(id);
    }

    @Override
    public Integer maxId() {
        return repoPersonaje.maxId();
    }

    @Override
    public void modificar(Personaje personaje) {
        repoPersonaje.modificar(personaje);
    }

    @Override
    public List<Personaje> listaDePersonajesEnMiColeccion(Coleccion coleccion) {
        return repoPersonaje.listaDePersonajesEnMiColeccion(coleccion);
    }

    @Override
    public Personaje traerPersonaje(Integer id) {
        return repoPersonaje.traerPersonaje(id);
    }

    @Override
    public List<Personaje> eliminarpersonaje(List<Personaje> listaPersonajes, Personaje personaje) {
        for (int i = 0; i < listaPersonajes.size(); i++) {
            if (listaPersonajes.get(i).getId().equals(personaje.getId())) {
                personaje.setEnMiColeccion(false);
                personaje.setEnVenta(true);
                listaPersonajes.remove(i);
            }
        }

        repoPersonaje.modificar(personaje);
        return listaPersonajes;
    }
    public List<Personaje> modificarPersonajeAIntercambiable(List<Personaje> listaPersonajes, Personaje personaje) {
        for (int i = 0; i < listaPersonajes.size(); i++) {
            if (listaPersonajes.get(i).getId().equals(personaje.getId())) {
                personaje.setIntercambiable(true);
                listaPersonajes.get(i).setIntercambiable(true);
            }
        }
        repoPersonaje.modificar(personaje);
        return listaPersonajes;
    }
    public List<Personaje> modificarPersonajeAColeccion(List<Personaje> listaPersonajes, Personaje personaje) {
        for (int i = 0; i < listaPersonajes.size(); i++) {
            if (listaPersonajes.get(i).getId().equals(personaje.getId())) {
                personaje.setIntercambiable(false);
                listaPersonajes.get(i).setIntercambiable(false);
            }
        }
        repoPersonaje.modificar(personaje);
        return listaPersonajes;
    }

    @Override
    public void eliminarPersonaje(Integer id) {
        repoPersonaje.eliminarPersonje(id);
    }

    @Override
    public List<Personaje> personajeOrdenadoMenorPrecio() {
        return repoPersonaje.personajeOrdenadoMenorPrecio();
    }

    @Override
    public List<Personaje> personajeOrdenadoMayorPrecio() {
        return repoPersonaje.personajeOrdenadoMayorPrecio();
    }

    @Override
    public List<Personaje> personajeOrdenadoAlfabeticamente() {
        return repoPersonaje.personajeOrdenadoAlfabeticamente();
    }

    public List<Integer> rounds(Personaje personaje, Personaje boot, Integer contadorUsuario, Integer contadorBoot){

        List<Integer> listaDeContadores = new ArrayList<>();

        if(personaje.getAtaque()> boot.getDefensa() && personaje.getDefensa() > boot.getAtaque()
                || boot.getAtaque() == personaje.getDefensa() && personaje.getAtaque() > boot.getDefensa()
                || personaje.getDefensa() > boot.getAtaque() && personaje.getAtaque() == boot.getDefensa() ){
            contadorUsuario++;
        }else if(personaje.getAtaque() == boot.getDefensa() && personaje.getDefensa() == boot.getAtaque()
                || personaje.equals(boot)){
            contadorUsuario++;
            contadorBoot++;
        }else{
            contadorBoot++;
        }
        listaDeContadores.add(contadorUsuario);
        listaDeContadores.add(contadorBoot);

      return listaDeContadores;
    }

    @Override
    public String quienGana(Integer contadorUsuario, Integer contadorBoot,Billetera billetera, HttpServletRequest request,
                          Nivel nivel,Usuario usuario){

        String mensaje;

        if(contadorUsuario > contadorBoot){
            mensaje = "ganaste";
            repoBilletera.sumarMonto(billetera, 1000.0f);
            request.getSession().setAttribute("billetera", billetera);
            nivel.setValorActual(nivel.getValorActual() + 2);
            if(nivel.getValorActual() > nivel.getValorMax()){
                Nivel nivelNuevo = repoNivel.crearNivel(nivel.getNumero() + 1 , nivel.getValorMax() + 5);
                usuario.setNivel(nivelNuevo);
                repoUsuario.modificar(usuario);
                request.getSession().setAttribute("nivel", nivelNuevo);
            }
            else{
                repoNivel.modificar(nivel);
                request.getSession().setAttribute("nivel", nivel);
            }
        } else if(contadorUsuario == contadorBoot){
            mensaje = "empate";
//            repoBilletera.sumarMonto(billetera, 500.0f);
//            request.getSession().setAttribute("billetera", billetera);
//            nivel.setValorActual(nivel.getValorActual() + 1);
//            if(nivel.getValorActual() > nivel.getValorMax()){
//                Nivel nivelNuevo = repoNivel.crearNivel(nivel.getNumero() + 1 , nivel.getValorMax() + 5);
//                usuario.setNivel(nivelNuevo);
//                repoUsuario.modificar(usuario);
//                request.getSession().setAttribute("nivel", nivelNuevo);
//            } else{
//                repoNivel.modificar(nivel);
//                request.getSession().setAttribute("nivel", nivel);
//            }
        } else{
            mensaje = "perdiste";
        }

        return mensaje;
    }

    @Override
    public Personaje personajeRandom(){
        Random preNumRandom        = new Random();
        Integer maxId              = repoPersonaje.maxId();
        int numRandom              = (int) (preNumRandom.nextDouble() * maxId + 1);
        Personaje personajeRandom  = repoPersonaje.buscarPorId(numRandom);

        return personajeRandom;
    }


}
