package tp02.e05;

public class Peluqueria {
    // Atributos
    private String nombre;
    private Peluquero[] peluqueros;
    private int cantidadPeluqueros;

    // Constructores
    public Peluqueria(String nombre, int limitePeluqueros) {
        this.nombre = nombre;
        this.peluqueros = new Peluquero[limitePeluqueros];
        this.cantidadPeluqueros = 0;
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public Peluquero getPeluquero(int numeroPeluquero) {
        if (numeroPeluquero >= 1 & numeroPeluquero <= peluqueros.length) {
            return peluqueros[numeroPeluquero - 1];
        }

        return null;
    }

    public void agregarPeluquero(Peluquero peluquero) {
        if (this.cantidadPeluqueros >= this.peluqueros.length) {
            Peluquero[] peluquerosAux = new Peluquero[this.peluqueros.length * 2];
            for (int i = 0; i < this.cantidadPeluqueros; i++)
                peluquerosAux[i] = this.peluqueros[i];
            this.peluqueros = peluquerosAux;
        }

        this.peluqueros[this.cantidadPeluqueros] = peluquero;
        cantidadPeluqueros++;
    }

    public void eliminarPeluquero() {
        if (this.cantidadPeluqueros > 0) {
            this.peluqueros[this.cantidadPeluqueros - 1] = null;
            this.cantidadPeluqueros--;

            if (this.cantidadPeluqueros <= this.peluqueros.length / 2) {
                Peluquero[] peluquerosAux = new Peluquero[this.cantidadPeluqueros];
                for (int i = 0; i < this.cantidadPeluqueros; i++)
                    peluquerosAux[i] = peluqueros[i];
                this.peluqueros = peluquerosAux;
            }
        }
    }

    public void registrarTurno(Turno turno) {
        turno.getPeluquero().registrarTurno(turno);
        turno.getCliente().registrarTurno(turno);
    }

    public Turno getPrimerTurnoDisponible() {
        if (this.cantidadPeluqueros > 0) {
            Turno primerTurnoPeluqueria = peluqueros[0].getPrimerTurnoDisponible();

            int i = 0;
            while (i < this.cantidadPeluqueros) {
                Turno primerTurnoPeluquero = peluqueros[i].getPrimerTurnoDisponible();
                if (primerTurnoPeluquero.getFechaHoraInicio().isBefore(primerTurnoPeluqueria.getFechaHoraInicio()))
                    primerTurnoPeluqueria = primerTurnoPeluquero;
                i++;
            }

            return primerTurnoPeluqueria;
        }

        return null;
    }

    @Override
    public String toString() {
        return  "Peluquería:\n" +
                "Nombre: " + this.nombre + " | " +
                "Cantidad de peluqueros: " + this.cantidadPeluqueros;
    }
}
