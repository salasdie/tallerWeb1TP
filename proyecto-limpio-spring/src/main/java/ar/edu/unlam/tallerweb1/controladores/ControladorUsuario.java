package ar.edu.unlam.tallerweb1.controladores;


import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;

@Controller
public class ControladorUsuario {


    @Inject
    private ServicioLogin servicioLogin;

    @RequestMapping("/perfilUsuario")
    public ModelAndView irPerfilUsuario() {

        ModelMap modelo = new ModelMap();

        Usuario pergilUsuario = new Usuario();
        modelo.put("usuario", pergilUsuario);

        return new ModelAndView("perfilUsuario", modelo);
    }


}
