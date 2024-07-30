package tp05.e05;

import java.util.ArrayList;

public class Empresa {
    // Atributos
    private String nombre;
    private ArrayList<Empleado> empleados;

    // Constructores
    public Empresa(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarEmpleado(Empleado empleado) {
        if (!this.empleados.contains(empleado))
            this.empleados.add(empleado);
    }

    public void eliminarEmpleado(Empleado empleado) {
        this.empleados.remove(empleado);
    }

    public double getTotalSueldos() {
        double total = 0;
        for (Empleado empleado : this.empleados)
            total += empleado.getSueldoTotal();
        return total;
    }

    @Override
    public String toString() {
        return "|EMPRESA| " +
                "Nombre: " + this.nombre + " - " +
                "Cantiad de empleados: " + this.empleados.size() + " - " +
                "Total de gastos en sueldos: " + getTotalSueldos();
    }
}
