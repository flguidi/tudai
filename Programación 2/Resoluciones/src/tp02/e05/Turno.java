package tp02.e05;

import java.time.LocalDateTime;

public class Turno {
    // Atributos
    private Peluquero peluquero;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    private Cliente cliente;

    // Constructores
    public Turno(Peluquero peluquero, Cliente cliente, LocalDateTime horario) {
        this.peluquero = peluquero;
        this.cliente = cliente;
        this.fechaHoraInicio = horario;
        this.fechaHoraFin = fechaHoraInicio.plusHours(1);
    }

    // Métodos
    public Peluquero getPeluquero() {
        return peluquero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }

    @Override
    public String toString() {
        return "Turno:\n" +
                "Peluquero: " + this.peluquero.getNombre() + " | " +
                "Cliente: " + this.cliente.getNombre() + " | " +
                "Fecha-hora inicio: " + this.fechaHoraInicio + " | " +
                "Fecha/hora fin: " + this.fechaHoraFin;
    }
}
