package ar.edu.unlam.tallerweb1.controladores;


import ar.edu.unlam.tallerweb1.modelo.Evento;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ControladorUsuario {


    @Inject
    private ServicioLogin servicioLogin;
    private ServicioUsuario servicioUsuario;

    @RequestMapping(path = "/perfilUsuario", method = RequestMethod.GET)
    public ModelAndView irPerfilUsuario(@RequestParam("id") long id, HttpServletRequest request) {

            ModelMap model = new ModelMap();

            Usuario usuarioBuscado = servicioLogin.consultarUsuarioPorId(id);
            if (usuarioBuscado != null) {
                request.getSession().setAttribute("rol", usuarioBuscado.getRol());
                request.getSession().setAttribute("nombre", usuarioBuscado.getNombreUsuario());
                request.getSession().setAttribute("apellido",usuarioBuscado.getApellidoUsuario());
                request.getSession().setAttribute("idusuario", usuarioBuscado.getId());
                request.getSession().setAttribute("peso", usuarioBuscado.getPeso());
                request.getSession().setAttribute("altura", usuarioBuscado.getAltura());
                request.getSession().setAttribute("imc", usuarioBuscado.getIndiceMasaCorporal());
                model.put("usuario", usuarioBuscado);

                return new ModelAndView("perfilUsuario", model);
            }
        return new ModelAndView("perfilUsuario", model);

        }

        //Controller para editar datos del usuario desde Pagina perfil Usuario
            @RequestMapping(path ="/modificarUsuario", method = RequestMethod.POST)
            public ModelAndView EditarDatosUsuario(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request) {
                ModelMap model = new ModelMap();
                usuario.setIndiceMasaCorporal();
                Usuario usuarioModificar = servicioLogin.consultarUsuarioPorId(usuario.getId());
                request.setAttribute("usuario",usuarioModificar);
                model.put("usuario",usuarioModificar);
                return new ModelAndView("modificarUsuario",model	);
            }


    }

