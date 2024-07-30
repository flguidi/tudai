package tp06.e02;

public class CentroComputos {
    // Atributos
    private ColaEspera computadoras;
    private ColaEspera procesos;

    // Constructores
    public CentroComputos() {
        this.computadoras = new ColaEspera();
        this.procesos = new ColaEspera();
    }

    // Métodos
    public void agregarComputadora(Computadora computadora) {
        if (computadora == null)
            return;

        if (procesos.tieneElementos()) {
            Proceso proceso = (Proceso) procesos.obtenerSiguiente();
            computadora.ejecutarProceso(proceso);
        } else {
            computadoras.agregarElemento(computadora);
        }
    }

    public void agregarProceso(Proceso proceso) {
        if (proceso == null)
            return;

        if (computadoras.tieneElementos()) {
            Computadora libre = (Computadora) computadoras.obtenerSiguiente();
            libre.ejecutarProceso(proceso);
        } else {
            procesos.agregarElemento(proceso);
        }
    }

    @Override
    public String toString() {
        return "Computadoras disponibles: " + computadoras + "\n" +
                "Procesos pendientes: " + procesos;
    }
}
