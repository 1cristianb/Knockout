package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class Billetera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Float monto;

    @OneToOne
    private Usuario usuario;
    public Billetera(Integer id,Float monto,Usuario usuario){
        this.id=id;
        this.monto=monto;
        this.usuario=usuario;
    }

    public Billetera() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
