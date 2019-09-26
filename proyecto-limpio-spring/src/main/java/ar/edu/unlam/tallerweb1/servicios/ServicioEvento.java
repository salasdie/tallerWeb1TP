package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Evento;

import java.util.List;

public interface ServicioEvento {
    List<Evento> consultarEvento ();
    boolean crearEventos();
}
