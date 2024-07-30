package tp03.e03;

public class Jugador {
    // Atributos
    private String nombre;
    private int puntos;
    private Personaje personajeElegido;

    // Constructores
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntos = 0;
        this.personajeElegido = null;
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public Personaje getPersonajeElegido() {
        return personajeElegido;
    }

    public void sacarCarta(Mazo mazo) {
        int indice = (int) (Math.random() * mazo.getPersonajes().size());
        if (mazo.getPersonaje(indice).isElegido()) {
            indice++;
            if (indice == mazo.getPersonajes().size())
                indice = 0;
        }
        this.personajeElegido = mazo.getPersonaje(indice);
        mazo.getPersonaje(indice).setElegido(true);
    }

    public void devolverCarta() {
        personajeElegido.setElegido(false);
    }

    public void incrementarPunto() {
        this.puntos++;
    }
}
