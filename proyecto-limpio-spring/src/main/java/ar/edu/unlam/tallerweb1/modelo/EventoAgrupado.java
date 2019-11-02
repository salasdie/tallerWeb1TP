package ar.edu.unlam.tallerweb1.modelo;

public class EventoAgrupado {

    private Evento evento;
    private Long cantidad;

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }
}
