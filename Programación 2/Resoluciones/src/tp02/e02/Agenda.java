package tp02.e02;

public class Agenda {
    // Atributos
    private Reunion[] reuniones;
    private int cantidadReuniones;

    // Constructores
    public Agenda(int limiteReuniones) {
        this.reuniones = new Reunion[limiteReuniones];
        this.cantidadReuniones = 0;
    }

    // Métodos
    public Reunion getReunion(int numeroReunion) {
        return reuniones[numeroReunion - 1];
    }

    public void agregarReunion(Reunion nuevaReunion) {
        if (!haySuperposicionesCon(nuevaReunion)) {
            if (cantidadReuniones >= this.reuniones.length) {
                Reunion[] reunionesAux = new Reunion[this.reuniones.length * 2];
                for (int i = 0; i < this.cantidadReuniones; i++)
                    reunionesAux[i] = this.reuniones[i];
                this.reuniones = reunionesAux;
            }

            this.reuniones[this.cantidadReuniones] = nuevaReunion;
            this.cantidadReuniones++;
            System.out.println("Reunión agregada.");
        } else {
            System.out.println("Hay otra reunión programada para esa fecha y hora.");
        }
    }

    public void eliminarReunion() {
        if (this.cantidadReuniones > 0) {
            this.reuniones[this.cantidadReuniones - 1] = null;
            this.cantidadReuniones--;

            if (this.cantidadReuniones <= this.reuniones.length / 2) {
                Reunion[] reunionesAux = new Reunion[this.cantidadReuniones];
                for (int i = 0; i < this.cantidadReuniones; i++)
                    reunionesAux[i] = reuniones[i];
                this.reuniones = reunionesAux;
            }
        }
    }

    public boolean haySuperposicionesCon(Reunion reunion) {
        boolean haySuperposicion = false;

        for (int i = 0; i < cantidadReuniones; i++) {
            if (reuniones[i].seSuperponeCon(reunion))
                haySuperposicion = true;
        }

        return haySuperposicion;
    }

    @Override
    public String toString() {
        return "Cantidad de reuniones: " + this.cantidadReuniones;
    }
}