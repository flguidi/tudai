package tp04.e04;

import java.time.LocalDate;

public class Jugador extends Integrante {
    // Atributos específicos
    private String posicion;
    private boolean zurdo;
    private int golesConvertidos;

    // Constructores
    public Jugador(String nombre, String apellido, String pasaporte, LocalDate fechaNacimiento,
                   String posicion, boolean zurdo, int golesConvertidos) {
        super(nombre, apellido, pasaporte, fechaNacimiento);
        this.posicion = posicion;
        this.zurdo = zurdo;
        this.golesConvertidos = golesConvertidos;
    }

    // Métodos específicos
    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public boolean isZurdo() {
        return zurdo;
    }

    public void setZurdo(boolean zurdo) {
        this.zurdo = zurdo;
    }

    public int getGolesConvertidos() {
        return golesConvertidos;
    }

    public void setGolesConvertidos(int golesConvertidos) {
        this.golesConvertidos = golesConvertidos;
    }

    @Override
    public String toString() {
        return super.toString() + " - " +
                "Posición: " + this.posicion + " - " +
                "Zurdo: " + this.zurdo + " - " +
                "Goles: " + this.golesConvertidos;
    }
}
