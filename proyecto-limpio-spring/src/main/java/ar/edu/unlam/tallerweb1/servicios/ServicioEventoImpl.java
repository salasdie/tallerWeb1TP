package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.dao.EventoDao;
import ar.edu.unlam.tallerweb1.modelo.Dificultad;
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
    public List<Evento> consultarEventosDificultad(String dificultad) {
        return  eventoDao.consultarEventoDificultad(dificultad); }

    @Override
    public List<Evento> consultarEventosLugar(String lugar){
        return eventoDao.consultarEventoLugar(lugar);
    }

//    @Override
//    public List<Evento> consultarEventosPorDificultad (String dificultad){
//        return eventoDao.consultarEventosPorDificultad(dificultad);
//    }

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
