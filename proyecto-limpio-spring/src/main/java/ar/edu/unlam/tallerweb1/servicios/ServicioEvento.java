package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Evento;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import java.util.List;

public interface ServicioEvento {
    List<Evento> consultarEvento ();
    List<Evento> consultarEventosUsuario (Usuario usuario);
    boolean crearEventos();
}
