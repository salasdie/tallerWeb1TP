package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Dificultad;
import ar.edu.unlam.tallerweb1.modelo.Evento;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;

@Repository("DificultadDao")
public class DificultadDaoImpl implements DificultadDao {
    @Inject
    private SessionFactory sessionFactory;


    @Override
    public List<Dificultad> traerSelectDificultad() {

        final Session session = sessionFactory.getCurrentSession();

        List<Dificultad> listaDificultad = session.createCriteria(Dificultad.class)

                .list();

        return listaDificultad;
    }
  }
