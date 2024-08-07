package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Billetera;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioBilletera {
    Billetera traerDatosBilletera(Usuario user);
    void agregarBilletera(Usuario usuario);
    void modificar(Billetera billetera);

    void restarDinero(Billetera billetera, Float monto);

    void sumarMonto(Billetera billetera, Float monto);
   void sumarMontoSinDescuento(Billetera billetera, Float monto);
    Float limitarDecimales(Billetera billetera);

    Double agregarPorcentajes(Double monto);
}
