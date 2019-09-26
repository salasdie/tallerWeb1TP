package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Evento;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository("eventoDao")
public class EventoDaoImpl implements EventoDao {
    @Inject
    private SessionFactory sessionFactory;

    @Override
    public List<Evento> consultarEvento () {

        final Session session = sessionFactory.getCurrentSession();

        List<Evento> listaEventos = session.createCriteria(Evento.class)
               // .add(Restrictions.eq("lugar", lugar))
                .list();

        return listaEventos;
    }

    @Override
    public void crearEventos(){

        final Session session = sessionFactory.getCurrentSession();

    // Creando eventos.

        Evento evento1 = new Evento("BA Corre", "Running, Caminatas, Acondicionamiento Físico", "Recoleta, Plaza Houssay","https://www.quepasaweb.com.ar/wp-content/uploads/2018/07/caminata-3.png");

        Evento evento2 = new Evento("Núcleos BA", "Basket, educación física infantil y Vóley.", "Flores, Espacio Juan XXIII","http://sansalvadordejujuy.gob.ar/wp-content/uploads/2017/05/Deportes-1.jpg");

        Evento evento3 = new Evento("Núcleos BA", "Gimnasia para adultos", "Mataderos, Polideportivo Dorrego", "http://isanidad.com/wp-content/uploads/2017/05/ejercicio_mayores.jpg");

        session.save(evento1);

        session.save(evento2);

        session.save(evento3);
    }

}
