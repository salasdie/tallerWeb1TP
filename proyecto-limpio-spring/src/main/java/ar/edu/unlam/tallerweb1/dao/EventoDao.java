package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Evento;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

public interface EventoDao {

    List<Evento> consultarEvento ();

    List<Evento> consultarEventosUsuario(Usuario usuario);

    List<Evento> consultarEventoDificultad(String dificultad);

    void crearEventos();

}
