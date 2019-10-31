package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Evento;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

public interface ServicioUsuario {
    List<Evento> consultarEvento();

    List<Evento> consultarEventosUsuario(Usuario usuario);

    Usuario consultarUsuarioPorId(long usuario);
}
