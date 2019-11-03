package ar.edu.unlam.tallerweb1.servicios;


import ar.edu.unlam.tallerweb1.dao.SuscripcionDao;
import ar.edu.unlam.tallerweb1.modelo.EventoAgrupado;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.inject.Inject;
import java.util.List;

@Service ("servicioSuscripcion")
@Transactional
public class ServicioSuscripcionImpl implements ServicioSuscripcion {

    @Inject
    private SuscripcionDao servicioSuscripcionDao;

    @Override
    public List<EventoAgrupado> ObtenerSuscripcionesPorRanking() {
        return servicioSuscripcionDao.ObtenerSuscripcionesPorRanking();
    }
}