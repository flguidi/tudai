package tp03.e04;

import java.time.LocalDate;
import java.time.Period;

public class Contacto {
    // Atributos
    private String nombre;
    private String apellido;
    private String numeroTelefono;
    private LocalDate fechaNacimiento;
    private int edad;
    private String direccion;
    private String email;

    // Constructores
    public Contacto(String nombre, String apellido, String numeroTelefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroTelefono = numeroTelefono;
    }

    public Contacto(String nombre, String apellido, String numeroTelefono, LocalDate fechaNacimiento,
                    String direccion, String email) {
        this(nombre, apellido, numeroTelefono);
        this.fechaNacimiento = fechaNacimiento;
        this.edad = getEdad();
        this.direccion = direccion;
        this.email = email;
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        this.edad = periodo.getYears();
        return edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        else if (obj == null || this.getClass() != obj.getClass())
            return false;

        Contacto otroContacto = (Contacto) obj;
        return this.getNombre().equals(otroContacto.getNombre())
                && this.getApellido().equals(otroContacto.getApellido())
                && this.getNumeroTelefono().equals(otroContacto.getNumeroTelefono());
    }

    @Override
    public String toString() {
        return "Apellido: " + this.apellido + " - " +
                "Nombre: " + this.nombre + " - " +
                "Edad: " + this.edad + " - " +
                "Número telefónico: " + numeroTelefono;
    }
}
