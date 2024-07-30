package tp04.e04;

import java.time.LocalDate;

public class Masajista extends Integrante {
    // Atributos específicos
    private String titulo;
    private int aniosExperiencia;

    // Constructores
    public Masajista(String nombre, String apellido, String pasaporte,
                     LocalDate fechaNacimiento, String titulo, int aniosExperiencia) {
        super(nombre, apellido, pasaporte, fechaNacimiento);
        this.titulo = titulo;
        this.aniosExperiencia = aniosExperiencia;
    }

    // Métodos específicos
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    @Override
    public String toString() {
        return  super.toString() + " - " +
                "Título: " + this.titulo + " - " +
                "Años de experiencia: " + this.aniosExperiencia;
    }
}
