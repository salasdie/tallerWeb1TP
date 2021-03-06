package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USUARIO")
    private Usuario usuario;

    private String nombre;
    private String descripcion;
    private String lugar;
    private String urlImagen;

//    @ManyToOne
//    @JoinColumn (name = "DIFICULTAD")
    private String dificultad;
    private Double CalEstimadasQuemadas;


    @ManyToMany(mappedBy = "eventos")
    private List<Usuario> usuarios = new LinkedList<>();

    {

    }

    public Evento() {
    }


    public Evento(String nombre, String descripcion, String lugar, String urlImagen, String dificultad, Usuario usuario) {

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.lugar = lugar;
        this.urlImagen = urlImagen;
        this.dificultad = dificultad;
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

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public Double getCalEstimadasQuemadas() {
        return CalEstimadasQuemadas;
    }

    public void setCalEstimadasQuemadas(Double calEstimadasQuemadas) {
        CalEstimadasQuemadas = calEstimadasQuemadas;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
