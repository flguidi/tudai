package tp03.e01;

import java.util.ArrayList;

public class EmpresaConsultora {
    // Atributos
    private String nombre;
    private ArrayList<Empleado> empleados;
    private ArrayList<Encuesta> encuestas;

    // Constructores
    public EmpresaConsultora(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
        this.encuestas = new ArrayList<>();
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public void agregarEmpleado(Empleado empleado) {
        this.empleados.add(empleado);
    }

    public void eliminarEmpleado(int indice) {
        if (indice >= 0 && indice < empleados.size())
            this.empleados.remove(indice);
    }

    public void agregarEncuesta(Encuesta encuesta) {
        this.encuestas.add(encuesta);
    }

    public void eliminarEncuesta(Encuesta encuesta) {
        this.encuestas.remove(encuesta);
    }

    @Override
    public String toString() {
        return "|CONSULTORA| " +
                "Nombre: " + this.nombre + " - " +
                "Cantidad de empleados: " + this.empleados.size() + " - " +
                "Cantidad de encuestas: " + this.encuestas.size();
    }
}
