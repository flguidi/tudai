package tp04.e06;

public class Empleado extends PersonaAsociada {
    // Atributos específicos
    private int numeroLegajo;
    private double sueldo;

    // Constructores
    public Empleado(String nombre, String apellido, int edad, int numeroLegajo, double sueldo) {
        super(nombre, apellido, edad);
        this.numeroLegajo = numeroLegajo;
        this.sueldo = sueldo;
        this.setRol("Empleado");
    }

    // Métodos específicos
    public int getNumeroLegajo() {
        return numeroLegajo;
    }

    public void setNumeroLegajo(int numeroLegajo) {
        this.numeroLegajo = numeroLegajo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;

        Empleado otroEmpleado = (Empleado) o;
        return this.getNumeroLegajo() == otroEmpleado.getNumeroLegajo();
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Número de legajo: " + this.numeroLegajo + "\n" +
                "Sueldo: " + this.sueldo;
    }
}
