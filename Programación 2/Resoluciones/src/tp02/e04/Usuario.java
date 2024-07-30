package tp02.e04;

import java.time.LocalDateTime;

public class Usuario {
    // Atributos
    private String nombre;
    private Turno[] historialTurnos;
    private int cantidadTurnos;

    // Constructores
    public Usuario(String nombre, int limiteTurnos) {
        this.nombre = nombre;
        this.historialTurnos = new Turno[limiteTurnos];
        this.cantidadTurnos = 0;
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean esSocio() {
        if (this.cantidadTurnos < 4)
            return false;

        LocalDateTime limiteSuperior = LocalDateTime.now();
        LocalDateTime limiteInferior = limiteSuperior.minusMonths(2);
        int contador = 0;
        for (int i = 0; i < this.cantidadTurnos; i++) {
            if (historialTurnos[i].getFechaInicio().isAfter(limiteInferior)
                    && historialTurnos[i].getFechaInicio().isBefore(limiteSuperior)) {
                contador++;
            }
        }

        return contador >= 4;
    }

    public void agregarTurno(Turno turno) {
        if (this.cantidadTurnos >= this.historialTurnos.length) {
            Turno[] historialTurnosAux = new Turno[this.historialTurnos.length * 2];
            for (int i = 0; i < this.cantidadTurnos; i++)
                historialTurnosAux[i] = this.historialTurnos[i];
            this.historialTurnos = historialTurnosAux;
        }

        this.historialTurnos[this.cantidadTurnos] = turno;
        this.cantidadTurnos++;
    }
}
