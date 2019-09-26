package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.dao.EventoDao;
import ar.edu.unlam.tallerweb1.modelo.Evento;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.Session;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UsuarioTest extends SpringTest {

    @Test
    @Transactional
    @Rollback

    public void buscarUsuario(){

        Usuario diego = new Usuario();
        Session session = getSession();

        session.save(diego);
        diego.setEmail("diegonsalas");
        session.update(diego);


        assertThat(diego.getEmail()).isEqualTo("diegonsalas");
    }




}
