package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Evento;
import ar.edu.unlam.tallerweb1.modelo.Suscripcion;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;


import javax.inject.Inject;
import java.util.List;

@Repository("suscripcionDao")
public class SuscripcionDaoImpl implements SuscripcionDao {

    @Inject
    private SessionFactory sessionFactory;

    @Override
    public List<Suscripcion> ObtenerSuscripcionesPorRanking() {

        final Session session = sessionFactory.getCurrentSession();


        final List suscripcionesPorRanking = session.createCriteria(Suscripcion.class)
                        //.createAlias("suscripcion", "s")
                        .setProjection(Projections.projectionList()
                        //.add(Projections.property("suscripcion.evento.id").as("evento"))
                        //.add(Projections.property("s.usuario").as("usuario"))
                        .add(Projections.groupProperty("evento"))
                        .add(Projections.rowCount(),"count"))
                        .addOrder(Order.desc("count"))
                        //.setResultTransformer(Transformers.aliasToBean(Suscripcion.class))
                        .list();
        return suscripcionesPorRanking;
    }

}

