package tp04.e03;

public class EmpleadoContratado {
    // Atributos
    private String nombre;
    private int id;
    private double sueldoFijo;

    // Constructores
    public EmpleadoContratado(String nombre, int id, double sueldoFijo) {
        this.nombre = nombre;
        this.id = id;
        this.sueldoFijo = sueldoFijo;
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSueldoFijo() {
        return sueldoFijo;
    }

    public void setSueldoFijo(double sueldoFijo) {
        this.sueldoFijo = sueldoFijo;
    }

    public double getSueldoSemanal() {
        return this.getSueldoFijo();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;

        EmpleadoContratado otroEmpleado = (EmpleadoContratado) o;
        return (this.getId() == otroEmpleado.getId());
    }

    @Override
    public String toString() {
        return "|Empleado| " +
                "Nombre: " + this.nombre + " - " +
                "ID: " + this.id + " - " +
                "Sueldo semanal: " + this.getSueldoSemanal();
    }
}
