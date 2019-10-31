package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Dificultad;
import ar.edu.unlam.tallerweb1.modelo.Evento;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

public interface DificultadDao {

    List<Dificultad> traerSelectDificultad();

}
