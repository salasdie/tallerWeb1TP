package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.dao.EventoDao;
import ar.edu.unlam.tallerweb1.modelo.Evento;
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
    public void CrearYConsultarEventos() {


        dao.crearEventos();
        List<Evento> listaEventos = dao.consultarEvento();

        assertThat(listaEventos.size()).isEqualTo(3);


    }

}
