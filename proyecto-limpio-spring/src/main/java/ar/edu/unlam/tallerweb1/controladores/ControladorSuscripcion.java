package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.EventoAgrupado;
import ar.edu.unlam.tallerweb1.servicios.ServicioSuscripcion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;

@Controller
public class ControladorSuscripcion {

    @Inject
    ServicioSuscripcion servicioSuscripcion;

    @RequestMapping(path = "/ranking", method = RequestMethod.GET)
    public ModelAndView ranking() {
        ModelMap model = new ModelMap();
        List<EventoAgrupado> listaSuscripciones = servicioSuscripcion.ObtenerSuscripcionesPorRanking();

        model.put("suscripcion", listaSuscripciones);

        return new ModelAndView("ranking", model);
    }
}