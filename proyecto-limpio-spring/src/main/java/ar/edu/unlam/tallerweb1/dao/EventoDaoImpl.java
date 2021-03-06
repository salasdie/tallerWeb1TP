package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Dificultad;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Evento;
import ar.edu.unlam.tallerweb1.modelo.Suscripcion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
    public List<Evento> consultarEventoDificultad(String dificultad) {

        final Session session = sessionFactory.getCurrentSession();

        List<Evento> eventosPorDificultad = session.createCriteria(Evento.class)
                //.createCriteria("dificultad", "d" )
                .add(Restrictions.eq("dificultad", dificultad))
                .list();
        return eventosPorDificultad;
    }

    @Override
    public List<Evento> consultarEventoLugar(String lugar){
        final Session session = sessionFactory.getCurrentSession();

        List<Evento> eventosPorLugar = session.createCriteria(Evento.class)
                .add(Restrictions.like("lugar", lugar+"%"))
                .list();
        return eventosPorLugar;
    }

//    @Override
//    public List<Evento> consultarEventosPorDificultad (String dificultad) {
//
//        final Session session = sessionFactory.getCurrentSession();
//
//        List<Evento> listaEventosPorNombre = session.createCriteria(Evento.class)
//                .add(Restrictions.eq("dificultad", dificultad))
//                .list();
//
//        return listaEventosPorNombre;
//    }


    @Override
    @PostConstruct
    @Transactional
    public void crearEventos(){

        final Session session = sessionFactory.openSession();

        Usuario mtvandoni = new Usuario();
        mtvandoni.setEmail("mtvandoni@gmail.com");
        mtvandoni.setPassword("123456");
        mtvandoni.setRol("Alumno");
            mtvandoni.setNombreUsuario("Micaela");
            mtvandoni.setApellidoUsuario("Vandoni");
            mtvandoni.setEdad(24);
            mtvandoni.setPeso(65.5);
            mtvandoni.setAltura(1.68);
            mtvandoni.setIndiceMasaCorporal();

        Usuario riverPLate = new Usuario();
        riverPLate.setEmail("riverplate@gmail.com");
        riverPLate.setPassword("muñeco");
        riverPLate.setRol("Empresa");
            riverPLate.setNombreUsuario("CARP");
            riverPLate.setNombreUsuario("CARP");

        Usuario dchamorro = new Usuario();
        dchamorro.setEmail("dchamorro@gmail.com");
        dchamorro.setPassword("12345");
        dchamorro.setRol("Profesor");
            dchamorro.setNombreUsuario("Debora");
            dchamorro.setApellidoUsuario("Chamorro");
            dchamorro.setPeso(65.5);
            dchamorro.setAltura(1.68);
            dchamorro.setIndiceMasaCorporal();

        Usuario mendezOng = new Usuario();
            mendezOng.setEmail("mendezOng@gmail.com");
            mendezOng.setPassword("098766");
            mendezOng.setRol("Profesor");
            mendezOng.setNombreUsuario("Martin");
            mendezOng.setApellidoUsuario("Mendez");
            mendezOng.setPeso(67.5);
            mendezOng.setAltura(1.68);
            mendezOng.setIndiceMasaCorporal();

        session.save(mtvandoni);
        session.save(riverPLate);
        session.save(dchamorro);
        session.save(mendezOng);

        Dificultad alta = new Dificultad();
        alta.setDescripcion("Alta");
        Dificultad media = new Dificultad();
        media.setDescripcion("Media");
        Dificultad baja = new Dificultad();
        baja.setDescripcion("Baja");

        session.save(alta);
        session.save(media);
        session.save(baja);

        Evento evento1 = new Evento("BA Corre", "Running, Caminatas, Acondicionamiento Fisico", "Recoleta, Plaza Houssay","https://www.quepasaweb.com.ar/wp-content/uploads/2018/07/caminata-3.png", "baja", mtvandoni);

        Evento evento2 = new Evento("Nucleos BA", "Basket, educacion fisica infantil y Voley.", "Flores, Espacio Juan XXIII","http://sansalvadordejujuy.gob.ar/wp-content/uploads/2017/05/Deportes-1.jpg","alta" ,dchamorro);

        Evento evento3 = new Evento("Nucleos BA", "Gimnasia para adultos", "Mataderos, Polideportivo Dorrego", "http://isanidad.com/wp-content/uploads/2017/05/ejercicio_mayores.jpg", "media",dchamorro);

        Evento evento4 = new Evento("BA Zona Oeste", "Gimnasia para Jovenes", "Mataderos, Polideportivo Dorrego", "http://isanidad.com/wp-content/uploads/2017/05/ejercicio_mayores.jpg","baja", mendezOng);

        session.save(evento1);

        session.save(evento2);

        session.save(evento3);

        session.save(evento4);
        mtvandoni.agregarEvento(evento1);

        Suscripcion suscripcion1 = new Suscripcion(mtvandoni, evento1);
        Suscripcion suscripcion2 = new Suscripcion(mendezOng, evento1);
        Suscripcion suscripcion3 = new Suscripcion(mtvandoni, evento2);
        Suscripcion suscripcion4 = new Suscripcion(dchamorro, evento3);


        session.save(suscripcion1);
        session.save(suscripcion2);
        session.save(suscripcion3);
        session.save(suscripcion4);


    }

}
