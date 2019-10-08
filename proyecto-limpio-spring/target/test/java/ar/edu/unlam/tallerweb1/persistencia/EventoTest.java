package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.dao.EventoDao;
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
    public void CrearYConsultarEventos() {


        dao.crearEventos();
        List<Evento> listaEventos = dao.consultarEvento();

        assertThat(listaEventos.size()).isEqualTo(3);


    }

    @Test
    @Transactional
    @Rollback
    public void listarEventosCreadoPor(){
        Usuario mtvandoni = new Usuario();
        mtvandoni.setEmail("mtvandoni@gmail.com");
        mtvandoni.setPassword("123456");
        mtvandoni.setRol("Alumno");

        Usuario riverPLate = new Usuario();
        riverPLate.setEmail("riverplate@gmail.com");
        riverPLate.setPassword("muñeco");
        riverPLate.setRol("Empresa");

        Usuario dchamorro = new Usuario();
        dchamorro.setEmail("dchamorro@gmail.com");
        dchamorro.setPassword("12345");
        dchamorro.setRol("Profesor");

        Usuario mendezOng = new Usuario();
        riverPLate.setEmail("mendezOng@gmail.com");
        riverPLate.setPassword("098766");
        riverPLate.setRol("ONG");

        getSession().save(mtvandoni);
        getSession().save(riverPLate);
        getSession().save(dchamorro);
        getSession().save(mendezOng);


        // Creando eventos.

        Evento evento1 = new Evento("BA Corre", "Running, Caminatas, Acondicionamiento Físico", "Recoleta, Plaza Houssay","https://www.quepasaweb.com.ar/wp-content/uploads/2018/07/caminata-3.png",mtvandoni);

        Evento evento2 = new Evento("Núcleos BA", "Basket, educación física infantil y Vóley.", "Flores, Espacio Juan XXIII","http://sansalvadordejujuy.gob.ar/wp-content/uploads/2017/05/Deportes-1.jpg", dchamorro);

        Evento evento3 = new Evento("Núcleos BA", "Gimnasia para adultos", "Mataderos, Polideportivo Dorrego", "http://isanidad.com/wp-content/uploads/2017/05/ejercicio_mayores.jpg", dchamorro);

        Evento evento4 = new Evento("BA Zona Oeste", "Gimnasia para Jovenes", "Mataderos, Polideportivo Dorrego", "http://isanidad.com/wp-content/uploads/2017/05/ejercicio_mayores.jpg", mendezOng);

        getSession().save(evento1);

        getSession().save(evento2);

        getSession().save(evento3);

        getSession().save(evento4);


        List<Evento> listarTodosLosEventosCreadosPor = dao.consultarEventosUsuario(dchamorro);
        assertThat(listarTodosLosEventosCreadosPor).hasSize(2);
    }

}
