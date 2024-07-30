package tp03.e03;

import java.util.ArrayList;

public class Mazo {
    // Atributos
    private ArrayList<Personaje> personajes;

    // Constructores
    public Mazo() {
        this.personajes = new ArrayList<>();
    }

    // Métodos
    public Personaje getPersonaje(int indice) {
        if (indice >= 0 && indice < personajes.size())
            return personajes.get(indice);

        return null;
    }

    public ArrayList<Personaje> getPersonajes() {
        return new ArrayList<>(personajes);
    }

    public void agregarPersonaje(Personaje personaje) {
        this.personajes.add(personaje);
    }

    public void eliminarPersonaje(int indice) {
        if (indice >= 0 && indice < personajes.size())
            personajes.remove(indice);
    }
}
