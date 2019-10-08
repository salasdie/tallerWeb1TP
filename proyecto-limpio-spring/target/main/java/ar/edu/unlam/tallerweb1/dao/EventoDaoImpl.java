package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Evento;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
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
    public List<Evento> consultarEventosUsuario(Usuario usuario) {

        final Session session = sessionFactory.getCurrentSession();

        List<Evento> eventosPorUsuario = session.createCriteria(Evento.class)
                     .add(Restrictions.eq("usuario", usuario))
                .list();

        return eventosPorUsuario;
    }


    @Override
    //@PostConstruct
    public void crearEventos(){

        final Session session = sessionFactory.getCurrentSession();


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


    // Creando eventos.

        Evento evento1 = new Evento("BA Corre", "Running, Caminatas, Acondicionamiento Físico", "Recoleta, Plaza Houssay","https://www.quepasaweb.com.ar/wp-content/uploads/2018/07/caminata-3.png",mtvandoni);

        Evento evento2 = new Evento("Núcleos BA", "Basket, educación física infantil y Vóley.", "Flores, Espacio Juan XXIII","http://sansalvadordejujuy.gob.ar/wp-content/uploads/2017/05/Deportes-1.jpg", dchamorro);

        Evento evento3 = new Evento("Núcleos BA", "Gimnasia para adultos", "Mataderos, Polideportivo Dorrego", "http://isanidad.com/wp-content/uploads/2017/05/ejercicio_mayores.jpg", dchamorro);

        Evento evento4 = new Evento("BA Zona Oeste", "Gimnasia para Jovenes", "Mataderos, Polideportivo Dorrego", "http://isanidad.com/wp-content/uploads/2017/05/ejercicio_mayores.jpg", mendezOng);

        session.save(evento1);

        session.save(evento2);

        session.save(evento3);

        session.save(evento4);
    }

}
