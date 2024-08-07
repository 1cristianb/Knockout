package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Billetera;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface RepositorioBilletera {
    Billetera traerDatosBilletera(Usuario user);
    void agregarBilletera(Usuario usuario);
    void modificar(Billetera billetera);

    Float restarDinero(Billetera billetera, Float monto);

    void sumarMonto(Billetera billetera, Float monto);
}
