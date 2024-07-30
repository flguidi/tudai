package tp04.e03;

import java.util.ArrayList;

public class Empresa {
    // Atributos
    private String nombre;
    private ArrayList<EmpleadoContratado> empleados;

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

    public ArrayList<EmpleadoContratado> getEmpleados() {
        return new ArrayList<>(empleados);
    }

    public EmpleadoContratado getEmpleadoById(int id) {
        for (EmpleadoContratado empleado : empleados) {
            if (empleado.getId() == id)
                return empleado;
        }
        return null;
    }

    public void agregarEmpleado(EmpleadoContratado empleado) {
        if (!empleados.contains(empleado))
            this.empleados.add(empleado);
    }

    public void eliminarEmpleado(int indice) {
        if (indice >= 0 && indice < empleados.size())
            this.empleados.remove(indice);
    }
}
