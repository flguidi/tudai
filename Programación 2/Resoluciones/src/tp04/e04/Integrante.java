package tp04.e04;

import java.time.LocalDate;

public class Integrante {
    // Atributos
    private String nombre;
    private String apellido;
    private String pasaporte;
    private LocalDate fechaNacimiento;
    private String estado;

    // Constructores
    public Integrante(String nombre, String apellido, String pasaporte, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.pasaporte = pasaporte;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = "En país de origen"; // Valor por defecto
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getPasaporte() {
        return pasaporte;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean estaDisponible() {
        return this.estado.equals("En país de origen");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;

        Integrante otroIntegrante = (Integrante) o;
        return this.getPasaporte().equals(otroIntegrante.getPasaporte());
    }

    @Override
    public String toString() {
        return "|INTEGRANTE| " +
                "Nombre: " + this.nombre + " - " +
                "Apellido: " + this.apellido + " - " +
                "Pasaporte: " + this.pasaporte + " - " +
                "Nacimiento: " + this.fechaNacimiento + " - " +
                "Estado: " + this.estado;
    }
}
