package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.EventoAgrupado;

import java.util.List;

public interface SuscripcionDao {
    List<EventoAgrupado> ObtenerSuscripcionesPorRanking();
}