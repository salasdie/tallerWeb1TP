package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.dao.EventoDao;
import ar.edu.unlam.tallerweb1.modelo.Evento;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service("servicioEvento")
@Transactional
public class ServicioEventoImpl implements ServicioEvento {

    @Inject
    private EventoDao eventoDao;

    @Override
    public List<Evento> consultarEvento () {
        return eventoDao.consultarEvento();
    }

    @Override
    public List consultarEventosUsuario (Usuario usuario) {
        return eventoDao.consultarEventosUsuario(usuario);
    }
    @Override
    public boolean crearEventos(){
        try{
            eventoDao.crearEventos();
        return true;
        }catch (Exception e){
             return false;
        }
    }
}
