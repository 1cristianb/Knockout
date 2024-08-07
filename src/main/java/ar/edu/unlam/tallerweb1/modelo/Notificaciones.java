package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class Notificaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensaje;
    private String asunto;

    @ManyToOne
    private Usuario usuario;

    private Notificar notificar;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getAsunto() {
        return asunto;
    }
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Notificar getNotificar() {
        return notificar;
    }
    public void setNotificar(Notificar notificar) {
        this.notificar = notificar;
    }
}
