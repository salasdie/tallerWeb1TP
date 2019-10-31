package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Dificultad;
import ar.edu.unlam.tallerweb1.modelo.Evento;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioEvento;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.*;


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
        List<String> dificultades = new ArrayList<>();
        dificultades.add("alta");
        dificultades.add("media");
        dificultades.add("baja");
        model.put("dificultades", dificultades);
        return new ModelAndView("eventos", model);
    }

    @RequestMapping(path = "/filtro-busquedaDificultad", method = RequestMethod.GET)
    public ModelAndView filtrarPorDificultad(@RequestParam("dificultad") String dificultad, HttpServletRequest request) {
        ModelMap model = new ModelMap();

        List<Evento> listaEventosFiltrados = servicioEvento.consultarEventosDificultad(dificultad);

        model.put("eventos", listaEventosFiltrados);
        List<String> dificultades = new ArrayList<>();
        dificultades.add("alta");
        dificultades.add("media");
        dificultades.add("baja");
        model.put("dificultades", dificultades);
        return new ModelAndView("eventos", model);
    }

    @RequestMapping(path = "/filtro-busquedaLugar", method = RequestMethod.GET)
    public ModelAndView filtrarPorLugar(@RequestParam("lugar") String lugar, HttpServletRequest request) {
        ModelMap model = new ModelMap();
        List<String> dificultades = new ArrayList<>();
        dificultades.add("alta");
        dificultades.add("media");
        dificultades.add("baja");
        model.put("dificultades", dificultades);
        List<Evento> listaEventosFiltrados = servicioEvento.consultarEventosLugar(lugar);
        model.put("eventos", listaEventosFiltrados);

        return new ModelAndView("eventos", model);
    }

    @RequestMapping(path = "/crear", method = RequestMethod.GET)
    public ModelAndView crear() {
        servicioEvento.crearEventos();
        return new ModelAndView("redirect:/login");
    }


}
