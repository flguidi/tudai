package tp03.e01;

import java.util.ArrayList;

public class Encuesta {
    // Atributos
    private Empleado empleado;
    private PersonaEncuestada personaEncuestada;
    private ArrayList<String> preguntas;
    private boolean completada;

    // Constructores
    public Encuesta(Empleado empleado, PersonaEncuestada personaEncuestada) {
        this.empleado = empleado;
        this.personaEncuestada = personaEncuestada;
        this.preguntas = new ArrayList<>();
        this.completada = false;
    }

    // Métodos
    public Empleado getEmpleado() {
        return empleado;
    }

    public String getDniPersonaEncuestada() {
        return personaEncuestada.getDni();
    }

    public void agregarPregunta(String pregunta) {
        if (!preguntas.contains(pregunta))
            preguntas.add(pregunta);
    }

    public void eliminarPregunta(String pregunta) {
        preguntas.remove(pregunta);
    }

    public void completar() {
        if (!completada && !personaEncuestada.completoEncuesta(this)) {
            completada = true;
            empleado.agregarEncuestaRealizada(this);
            personaEncuestada.agregarEncuestaRealizada(this);
        } else {
            System.out.println("Esta encuesta ya ha sido realizada");
        }
    }

    public boolean isCompletada() {
        return completada;
    }

    @Override
    public String toString() {
        return "|ENCUESTA| " +
                "Encuestador: " + this.empleado.getNombre() + " - " +
                "Persona encuestada: " + this.personaEncuestada.getNombre() + " - " +
                "DNI: " + this.personaEncuestada.getDni() + " - " +
                "Completada: " + this.completada;
    }
}
