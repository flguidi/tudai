package tp04.e04;

import java.time.LocalDate;

public class Entrenador extends Integrante {
    // Atributos específicos
    private String idFederacion;

    // Constructores
    public Entrenador(String nombre, String apellido, String pasaporte, LocalDate fechaNacimiento,
                      String idFederacion) {
        super(nombre, apellido, pasaporte, fechaNacimiento);
        this.idFederacion = idFederacion;
    }

    // Métodos específicos
    public String getIdFederacion() {
        return idFederacion;
    }

    public void setIdFederacion(String idFederacion) {
        this.idFederacion = idFederacion;
    }

    @Override
    public String toString() {
        return super.toString() + " - " +
                "ID Federación: " + this.idFederacion;
    }
}
