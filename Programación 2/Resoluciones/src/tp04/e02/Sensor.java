package tp04.e02;

public class Sensor {
    // Atributos
    private String zona;
    private boolean vidrioRoto;
    private boolean puertaVentanaAbierta;
    private boolean movimientoDetectado;

    // Constructores
    public Sensor(String zona) {
        this.zona = zona;
        this.vidrioRoto = false;
        this.puertaVentanaAbierta = false;
        this.movimientoDetectado = false;
    }

    // Métodos
    public String getZona() {
        return zona;
    }

    public boolean comprobarZona() {
        return vidrioRoto || puertaVentanaAbierta || movimientoDetectado;
    }

    public void activarVidrioRoto() {
        vidrioRoto = true;
    }

    public void desactivarVidrioRoto() {
        vidrioRoto = false;
    }

    public void activarPuertaVentanaAbierta() {
        puertaVentanaAbierta = true;
    }

    public void desactivarPuertaVentanaAbierta() {
        puertaVentanaAbierta = false;
    }

    public void activarMovimientoDetectado() {
        movimientoDetectado = true;
    }

    public void desactivarMovimientoDetectado() {
        movimientoDetectado = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;

        Sensor otroSensor = (Sensor) o;
        return this.getZona().equals(otroSensor.getZona());
    }
}
