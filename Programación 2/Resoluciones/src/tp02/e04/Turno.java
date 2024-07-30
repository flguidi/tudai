package tp02.e04;

import java.time.LocalDateTime;

public class Turno {
    // Atributos
    private Cancha cancha;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private Usuario usuario;

    // Constructores
    public Turno(Cancha cancha, LocalDateTime fechaInicio, Usuario usuario) {
        this.cancha = cancha;
        this.usuario = usuario;
        this.fechaInicio = fechaInicio;
        this.fechaFin = this.fechaInicio.plusHours(1);
    }

    // Métodos
    public Cancha getCancha() {
        return cancha;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public double calcularPrecio() {
        if (usuario.esSocio())
            return cancha.getPrecioHora() * 0.9;

        return cancha.getPrecioHora();
    }

    public boolean seSuperponeCon(Turno otroTurno) {
        LocalDateTime inicioOtro = otroTurno.getFechaInicio();
        LocalDateTime finOtro = otroTurno.getFechaFin();
        String nombreOtro = otroTurno.getCancha().getNombre();

        return this.getCancha().getNombre().equals(nombreOtro)
                && this.fechaInicio.isBefore(finOtro) || this.fechaInicio.isEqual(finOtro)
                && this.fechaFin.isEqual(inicioOtro) || this.fechaFin.isAfter(inicioOtro);
    }
}
