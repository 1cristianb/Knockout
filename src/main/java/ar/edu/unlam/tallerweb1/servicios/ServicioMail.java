package ar.edu.unlam.tallerweb1.servicios;

public interface ServicioMail {
    void enviarMailRegistro(String email);

    void verificarMail(String email);
}
