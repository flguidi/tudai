package tp06.e03;

public class PuertoCereales {
    // Atributos
    private ColaEspera barcos;
    private ColaEspera camiones;

    // Constructores
    public PuertoCereales() {
        this.barcos = new ColaEspera();
        this.camiones = new ColaEspera();
    }

    // Métodos
    public void cargarBarco(Barco barco) {
        if (barco == null || barco.getCargamento() != null)
            return;

        if (camiones.tieneElementos()) {
            Camion siguienteCamion = (Camion) camiones.obtenerSiguiente();
            barco.cargarCon(siguienteCamion);
        } else {
            barcos.agregarElemento(barco);
        }
    }

    public Barco obtenerSiguienteBarco() {
        return (Barco) barcos.obtenerSiguiente();
    }

    public void descargarCamion(Camion camion) {
        if (camion == null || camion.getCargamento() == null)
            return;

        if (barcos.tieneElementos()) {
            Barco libre = (Barco) barcos.obtenerSiguiente();
            libre.cargarCon(camion);
        } else {
            camiones.agregarElemento(camion);
        }
    }

    public Camion obtenerSiguienteCamion() {
        return (Camion) camiones.obtenerSiguiente();
    }

    @Override
    public String toString() {
        return "Barcos disponibles: " + barcos + "\n" +
                "Camiones pendientes: " + camiones;
    }
}
