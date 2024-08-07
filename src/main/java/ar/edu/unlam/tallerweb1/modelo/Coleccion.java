package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Coleccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Usuario usuario;

    @JoinTable(name = "coleccion_personaje", joinColumns = @JoinColumn(name = "fk_coleccion", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "fk_personaje", nullable = false))
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Personaje> personajes;

    public Coleccion(Integer id,Usuario usuario,List personajes){
        this.id=id;
        this.usuario=usuario;
        this.personajes=personajes;
    }

    public Coleccion() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(List<Personaje> personajes) {
        this.personajes = personajes;
    }

}
