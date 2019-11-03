package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class Suscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn (name = "USUARIO")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn (name = "EVENTO")
    private Evento evento;

    public Suscripcion (){

    }

    public Suscripcion(Usuario usuario, Evento evento) {
        this.usuario = usuario;
        this.evento = evento;

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}