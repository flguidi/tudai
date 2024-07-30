package tp02.e05;

import java.time.LocalDateTime;

public class Cliente {
    // Atributos
    private String nombre;
    private Turno[] historialTurnos;
    private int cantidadTurnos = 0;

    // Constructores
    public Cliente(String nombre, int limiteHistorialTurnos) {
        this.nombre = nombre;
        this.historialTurnos = new Turno[limiteHistorialTurnos];
        this.cantidadTurnos = 0;
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean esFrecuente() {
        LocalDateTime limiteSuperior = LocalDateTime.now();
        LocalDateTime limiteInferior = limiteSuperior.minusMonths(1);

        boolean esFrecuente = false;

        for (int i = 0; i < this.cantidadTurnos; i++) {
            if (historialTurnos[i].getFechaHoraInicio().isAfter(limiteInferior)
                    && historialTurnos[i].getFechaHoraInicio().isBefore(limiteSuperior)) {
                esFrecuente = true;
                break;
            }
        }

        return esFrecuente;
    }

    public void registrarTurno(Turno turno) {
        if (this.cantidadTurnos >= this.historialTurnos.length) {
            Turno[] historialTurnosAux = new Turno[this.historialTurnos.length * 2];
            for (int i = 0; i < this.cantidadTurnos; i++)
                historialTurnosAux[i] = this.historialTurnos[i];
            this.historialTurnos = historialTurnosAux;
        }

        this.historialTurnos[this.cantidadTurnos] = turno;
        cantidadTurnos++;
    }

    public void eliminarTurno() {
        if (this.cantidadTurnos > 0) {
            this.historialTurnos[this.cantidadTurnos - 1] = null;
            this.cantidadTurnos--;

            if (this.cantidadTurnos <= this.historialTurnos.length / 2) {
                Turno[] historialTurnosAux = new Turno[this.cantidadTurnos];
                for (int i = 0; i < this.cantidadTurnos; i++)
                    historialTurnosAux[i] = historialTurnos[i];
                this.historialTurnos = historialTurnosAux;
            }
        }
    }

    @Override
    public String toString() {
        return "Cliente:\n" +
                "Nombre: " + this.nombre + " | " +
                "Cantidad de turnos asignados: " + this.cantidadTurnos;
    }
}
