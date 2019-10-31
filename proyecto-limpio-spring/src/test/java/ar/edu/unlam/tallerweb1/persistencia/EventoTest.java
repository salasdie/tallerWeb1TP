package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.dao.EventoDao;
import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.Evento;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class EventoTest extends SpringTest {

    @Autowired
    private EventoDao dao;
    @Test
    @Transactional
    @Rollback
    public void agregarEventoAUsuario(){
        Usuario seba = new Usuario();
        getSession().save(seba);

        Evento evento = new Evento();
        getSession().save(evento);

        seba.agregarEvento(evento);
        getSession().update(seba);

        Usuario usuarioBuscado = getSession().get(Usuario.class, seba.getId());
        assertThat(usuarioBuscado.getEventos()).hasSize(1);
    }


    @Test
    @Transactional
    @Rollback
    public void CrearYConsultarEventos() {
        List<Evento> listaEventos = dao.consultarEvento();
        assertThat(listaEventos.size()).isEqualTo(4);
    }

    @Test
    @Transactional
    @Rollback
    public void listarEventosCreadoPor(){


       // List<Evento> listarTodosLosEventosCreadosPor = dao.consultarEventosUsuario(dchamorro);
       // assertThat(listarTodosLosEventosCreadosPor).hasSize(2);
    }

    @Test
    @Transactional
    @Rollback
    public void listarEventosPorDificultad(){



        String dificultad = "alta";
        List<Evento> listarTodosLosEventosConDificultadAlta = dao.consultarEventoDificultad(dificultad);
        assertThat(listarTodosLosEventosConDificultadAlta).hasSize(1);
    }
}
