package tp04.e06;

import java.util.ArrayList;

public class Jerarquico extends Empleado {
    // Atributos específicos
    private ArrayList<Empleado> empleados;

    // Constructores
    public Jerarquico(String nombre, String apellido, int edad, int numeroLegajo, double sueldo) {
        super(nombre, apellido, edad, numeroLegajo, sueldo);
        this.empleados = new ArrayList<>();
        this.setRol("Jerárquico");
    }

    // Métodos específicos
    public ArrayList<Empleado> getEmpleados() {
        return new ArrayList<>(this.empleados);
    }

    public Empleado getEmpleadoByLegajo(int legajo) {
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getNumeroLegajo() == legajo)
                return empleados.get(i);
        }
        return null;
    }

    public void agregarEmpleado(Empleado empleado) {
        if (!empleados.contains(empleado))
            empleados.add(empleado);
    }

    public void eliminarEmpleado(int numeroLegajo) {
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getNumeroLegajo() == numeroLegajo) {
                empleados.remove(empleados.get(i));
                return;
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Cantidad de empleados a cargo: " + this.empleados.size();
    }
}
