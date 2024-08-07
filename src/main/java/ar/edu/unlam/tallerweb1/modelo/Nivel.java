package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Nivel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer numero;
    private Integer valorMax;
    private Integer valorActual;

//    public Nivel(Integer id, Integer numero, Integer valorMax, Integer valorActual) {
//        this.id = id;
//        this.numero = numero;
//        this.valorMax = valorMax;
//        this.valorActual = valorActual;
//    }
//
//    public Nivel() {
//
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getValorMax() {
        return valorMax;
    }

    public void setValorMax(Integer valorMax) {
        this.valorMax = valorMax;
    }

    public Integer getValorActual() {
        return valorActual;
    }

    public void setValorActual(Integer valorActual) {
        this.valorActual = valorActual;
    }
}
