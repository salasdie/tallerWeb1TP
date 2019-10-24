package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Evento;
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
    @PostConstruct
    @Transactional
    public void crearEventos(){

        final Session session = sessionFactory.openSession();


            Usuario mtvandoni = new Usuario();
            mtvandoni.setEmail("mtvandoni@gmail.com");
            mtvandoni.setPassword("123456");
            mtvandoni.setRol("Alumno");
            mtvandoni.setNombreUsuario("Micaela");
            mtvandoni.setEdad(24);
            mtvandoni.setPeso(65.5);
            mtvandoni.setAltura(1.68);
            mtvandoni.setIndiceMasaCorporal(mtvandoni.getPeso(),mtvandoni.getAltura());

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
            dchamorro.setPeso(65.5);
            dchamorro.setAltura(1.68);
            dchamorro.setIndiceMasaCorporal(dchamorro.getPeso(),dchamorro.getAltura());

            Usuario mendezOng = new Usuario();
            mendezOng.setEmail("mendezOng@gmail.com");
            mendezOng.setPassword("098766");
            mendezOng.setRol("Profesor");
            mendezOng.setNombreUsuario("Martin");
            mendezOng.setPeso(67.5);
            mendezOng.setAltura(1.68);
            mendezOng.setIndiceMasaCorporal(mendezOng.getPeso(),mendezOng.getAltura());

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
    }

}
