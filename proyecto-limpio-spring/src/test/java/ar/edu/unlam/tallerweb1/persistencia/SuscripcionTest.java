package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.dao.SuscripcionDao;
import ar.edu.unlam.tallerweb1.modelo.Evento;
import ar.edu.unlam.tallerweb1.modelo.Suscripcion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SuscripcionTest extends SpringTest {


    @Autowired

    private SuscripcionDao dao;

    @Test
    @Transactional
    @Rollback

    public void contarEventosPorNombre(){

        final Session session = getSession();

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

        session.save(mtvandoni);
        session.save(riverPLate);
        session.save(dchamorro);
        session.save(mendezOng);

        Evento evento1 = new Evento("BA Corre", "Running, Caminatas, Acondicionamiento Fisico", "Recoleta, Plaza Houssay","https://www.quepasaweb.com.ar/wp-content/uploads/2018/07/caminata-3.png", "baja", mtvandoni);

        Evento evento2 = new Evento("Nucleos BA", "Basket, educacion fisica infantil y Voley.", "Flores, Espacio Juan XXIII","http://sansalvadordejujuy.gob.ar/wp-content/uploads/2017/05/Deportes-1.jpg","alta" ,dchamorro);

        Evento evento3 = new Evento("Nucleos BA", "Gimnasia para adultos", "Mataderos, Polideportivo Dorrego", "http://isanidad.com/wp-content/uploads/2017/05/ejercicio_mayores.jpg", "media",dchamorro);

        Evento evento4 = new Evento("BA Zona Oeste", "Gimnasia para Jovenes", "Mataderos, Polideportivo Dorrego", "http://isanidad.com/wp-content/uploads/2017/05/ejercicio_mayores.jpg","baja", mendezOng);

        session.save(evento1);

        session.save(evento2);

        session.save(evento3);

        session.save(evento4);

        Suscripcion suscripcion1 = new Suscripcion(mtvandoni, evento1);
        Suscripcion suscripcion5 = new Suscripcion(mtvandoni, evento1);
        Suscripcion suscripcion2 = new Suscripcion(mendezOng, evento1);
        Suscripcion suscripcion3 = new Suscripcion(mtvandoni, evento2);
        Suscripcion suscripcion4 = new Suscripcion(dchamorro, evento3);
        Suscripcion suscripcion6 = new Suscripcion(dchamorro, evento3);

        session.save(suscripcion1);
        session.save(suscripcion2);
        session.save(suscripcion3);
        session.save(suscripcion4);
        session.save(suscripcion5);
        session.save(suscripcion6);

       /* final List list = session.createCriteria(Suscripcion.class)
                .setProjection(Projections.projectionList()
                        .add(Projections.groupProperty("evento"))
                        .add(Projections.count("usuario")))
                        .list();*/

        List<Suscripcion> listarCantidadDeEventosPorNombre = dao.ObtenerSuscripcionesPorRanking();
        assertThat(listarCantidadDeEventosPorNombre).hasSize(3);



       // assertThat(diego.getEmail()).isEqualTo("diegonsalas");





    }

}
