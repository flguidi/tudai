package tp03.e01;

import java.util.ArrayList;

public class PersonaEncuestada {
    // Atributos
    private String nombre;
    private String dni;
    private ArrayList<Encuesta> encuestasRealizadas;

    // Constructores
    public PersonaEncuestada(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.encuestasRealizadas = new ArrayList<>();
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public void agregarEncuestaRealizada(Encuesta encuesta) {
        this.encuestasRealizadas.add(encuesta);
    }

    public boolean completoEncuesta(Encuesta encuesta) {
        return encuestasRealizadas.contains(encuesta);
    }

    @Override
    public String toString() {
        return "|PERSONA ENTREVISTADA| " +
                "Nombre: " + this.nombre + " - " +
                "DNI: " + this.dni + " - " +
                "Cantidad de encuestas realizadas: " + this.encuestasRealizadas.size();
    }
}
