package tp07.e01;

import java.util.ArrayList;

public class Cultivo {
    // Atributos
    private String nombre;
    private ArrayList<Enfermedad> enfermedadesFrecuentes;

    // Constructores
    public Cultivo(String nombre) {
        this.nombre = nombre;
        this.enfermedadesFrecuentes = new ArrayList<>();
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarEnfermedadFrecuente(Enfermedad enfermedad) {
        if (!enfermedadesFrecuentes.contains(enfermedad))
            enfermedadesFrecuentes.add(enfermedad);
    }

    public void eliminarEnfermedadFrecuente(Enfermedad enfermedad) {
        enfermedadesFrecuentes.remove(enfermedad);
    }

    @Override
    public boolean equals(Object o) {
        try {
            Cultivo otroCultivo = (Cultivo) o;
            return this.getNombre().equals(otroCultivo.getNombre());
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return nombre;
    }
}
