package ar.edu.unlam.tallerweb1.servicios;
import ar.edu.unlam.tallerweb1.modelo.EventoAgrupado;

import java.util.List;

public interface ServicioSuscripcion {


    List<EventoAgrupado> ObtenerSuscripcionesPorRanking ();
}