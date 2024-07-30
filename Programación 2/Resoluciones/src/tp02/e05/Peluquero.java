package tp02.e05;

public class Peluquero {
    // Atributos
    private String nombre;
    private Turno[] turnos;
    private int cantidadTurnos;

    // Constructores
    public Peluquero(String nombre, int limiteTurnos) {
        this.nombre = nombre;
        this.turnos = new Turno[limiteTurnos];
        this.cantidadTurnos = 0;
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public Turno getTurno(int numeroTurno) {
        return turnos[numeroTurno - 1];
    }

    public void registrarTurno(Turno turno) {
        if (this.cantidadTurnos >= this.turnos.length) {
            Turno[] turnosAux = new Turno[this.turnos.length * 2];
            for (int i = 0; i < this.cantidadTurnos; i++)
                turnosAux[i] = this.turnos[i];
            this.turnos = turnosAux;
        }

        this.turnos[this.cantidadTurnos] = turno;
        cantidadTurnos++;
    }

    public void cancelarTurno() {
        if (this.cantidadTurnos > 0) {
            this.turnos[this.cantidadTurnos - 1] = null;
            this.cantidadTurnos--;

            if (this.cantidadTurnos <= this.turnos.length / 2) {
                Turno[] turnosAux = new Turno[this.cantidadTurnos];
                for (int i = 0; i < this.cantidadTurnos; i++)
                    turnosAux[i] = this.turnos[i];
                this.turnos = turnosAux;
            }
        }
    }

    public Turno getPrimerTurnoDisponible() {
        if (this.cantidadTurnos > 0) {
            Turno primerTurnoDisponible = turnos[0];

            int i = 0;
            while (i < this.cantidadTurnos) {
                if (turnos[i].getFechaHoraInicio().isBefore(primerTurnoDisponible.getFechaHoraInicio()))
                    primerTurnoDisponible = turnos[i];
                i++;
            }

            return primerTurnoDisponible;
        }

        return null;
    }

    @Override
    public String toString() {
        return "Peluquero:\n" +
                "Nombre: " + this.nombre + " | " +
                "Cantidad de turnos: " + this.cantidadTurnos + " | " +
                "Primer turno disponible: " + this.getPrimerTurnoDisponible().getFechaHoraInicio();
    }
}
