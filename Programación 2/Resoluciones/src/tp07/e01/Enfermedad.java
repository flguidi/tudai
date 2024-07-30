package tp07.e01;

import java.util.ArrayList;

public class Enfermedad {
    // Atributos
    private String nombre;
    private ArrayList<String> estadosPatologicos; // que deben ser tratados

    // Constructores
    public Enfermedad(String nombre) {
        this.nombre = nombre;
        this.estadosPatologicos = new ArrayList<>();
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarEstadoPatologico(String estadoPatologico) {
        if (!estadosPatologicos.contains(estadoPatologico))
            estadosPatologicos.add(estadoPatologico);
    }

    public void eliminarEstadoPatologico(String estadoPatologico) {
        estadosPatologicos.remove(estadoPatologico);
    }

    public boolean poseeEstadoPatologico(String estadoPatologico) {
        return estadosPatologicos.contains(estadoPatologico);
    }

    @Override
    public boolean equals(Object o) {
        try {
            Enfermedad otraEnfermedad = (Enfermedad) o;
            return this.getNombre().equals(otraEnfermedad.getNombre());
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return nombre;
    }
}
