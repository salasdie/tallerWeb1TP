package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Evento;

import java.util.List;

public interface EventoDao {

    List<Evento> consultarEvento ();

    void crearEventos();
}
