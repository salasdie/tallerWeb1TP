package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn (name = "USUARIO")
    private Usuario usuario;

    private String nombre;
    private String descripcion;
    private String lugar;
    private String urlImagen;


    public Evento(){}


    public Evento(String nombre, String descripcion, String lugar, String urlImagen, Usuario usuario) {

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.lugar = lugar;
        this.urlImagen = urlImagen;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
}
