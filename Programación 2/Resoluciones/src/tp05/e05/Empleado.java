package tp05.e05;

public class Empleado {
    // Atributos
    private String nombre;
    private String apellido;
    private String dni;
    private double sueldoMensual;

    // Constructores
    public Empleado(String nombre, String apellido, String dni, double sueldoMensual) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.sueldoMensual = sueldoMensual;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getSueldoMensual() {
        return sueldoMensual;
    }

    public void setSueldoMensual(double sueldoMensual) {
        this.sueldoMensual = sueldoMensual;
    }

    public double getSueldoTotal() {
        return getSueldoMensual();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;

        Empleado otroEmpleado = (Empleado) o;
        return (this.getDni().equals(otroEmpleado.getDni()));
    }

    @Override
    public String toString() {
        return "|EMPLEADO| " +
                "Apellido y nombre: " + this.apellido + ", " + this.nombre + " - " +
                "DNI: " + this.dni + " - " +
                "Sueldo mensual total: " + this.getSueldoTotal();
    }
}
