package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Evento;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioEvento;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


@Controller
public class ControladorEvento {

    @Inject
    ServicioEvento servicioEvento;


    @RequestMapping(path = "/eventos", method = RequestMethod.GET)
        public ModelAndView eventos() {
            //servicioEvento.crearEventos();
            ModelMap model = new ModelMap();
           List<Evento> listaEventos = servicioEvento.consultarEvento();

            model.put("eventos", listaEventos);

            return new ModelAndView("eventos", model);
    }

    @RequestMapping(path = "/crear", method = RequestMethod.GET)
    public ModelAndView crear() {
            servicioEvento.crearEventos();
        return new ModelAndView("redirect:/login");
    }


}
