package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.EventoAgrupado;
import ar.edu.unlam.tallerweb1.modelo.Suscripcion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
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
    public List<EventoAgrupado> ObtenerSuscripcionesPorRanking() {

        final Session session = sessionFactory.getCurrentSession();


        final List<EventoAgrupado> suscripcionesPorRanking = session.createCriteria(Suscripcion.class)
              //.createAlias("suscripcion", "s")
                .setProjection(Projections.projectionList()
                        //.add(Projections.property("suscripcion.evento.id").as("evento"))
                        //.add(Projections.property("s.usuario").as("usuario"))
                        .add(Projections.groupProperty("evento"), "evento")
                        .add(Projections.rowCount(),"cantidad"))
                .addOrder(Order.desc("cantidad"))
                .setResultTransformer(Transformers.aliasToBean(EventoAgrupado.class))
                .list();
        return suscripcionesPorRanking;
    }

}
