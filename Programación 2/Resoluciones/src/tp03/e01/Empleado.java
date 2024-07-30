package tp03.e01;

import java.util.ArrayList;

public class Empleado {
    // Atributos
    private String nombre;
    private ArrayList<Encuesta> encuestasRealizadas;

    // Constructores
    public Empleado(String nombre) {
        this.nombre = nombre;
        this.encuestasRealizadas = new ArrayList<>();
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public ArrayList<Encuesta> getEncuestasRealizadas() {
        return encuestasRealizadas;
    }

    public void agregarEncuestaRealizada(Encuesta encuesta) {
        this.encuestasRealizadas.add(encuesta);
    }

    public void eliminarEncuesta(int indice) {
        encuestasRealizadas.remove(indice);
    }

    public int getCantEncuestasRealizadas() {
        return encuestasRealizadas.size();
    }

    @Override
    public String toString() {
        return "|EMPLEADO| " +
                "Nombre: " + nombre + " - " +
                "Cantidad de encuestas realizadas: " + encuestasRealizadas.size();
    }
}
