package tp04.e01;

public class Alarma {
    // Atributos
    private boolean vidrioRoto;
    private boolean puertaVentanaAbierta;
    private boolean movimientoDetectado;
    private Timbre timbre;

    // Constructores
    public Alarma() {
        this.vidrioRoto = false;
        this.puertaVentanaAbierta = false;
        this.movimientoDetectado = false;
        this.timbre = new Timbre();
    }

    // Métodos
    public boolean comprobar() {
        if (vidrioRoto || puertaVentanaAbierta || movimientoDetectado) {
            timbre.hacerSonar();
            return true;
        }

        return false;
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
        movimientoDetectado = false;
    }
}
