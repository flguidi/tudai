package tp07.e04;

import tp07.e04.condiciones.Condicion;
import java.util.ArrayList;

public class Tablero {
    // Atributos
    private int nivel;
    private double puntajeMinimo;
    private ArrayList<Ficha> fichas;
    private double dificultad;

    // Constructores
    public Tablero(int nivel, double puntajeMinimo) {
        this.nivel = nivel;
        this.puntajeMinimo = puntajeMinimo;
        this.fichas = new ArrayList<>();
        this.dificultad = 0.0;
    }

    // Métodos
    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public double getPuntajeMinimo() {
        return puntajeMinimo;
    }

    public void setPuntajeMinimo(double puntajeMinimo) {
        this.puntajeMinimo = puntajeMinimo;
    }

    public void agregarFicha(Ficha ficha) {
        if (ficha != null) {
            fichas.add(ficha);
            setDificultad();
        }
    }

    public void eliminarFicha(Ficha ficha) {
        fichas.remove(ficha);
    }

    public ArrayList<Ficha> buscarFichas(Condicion condicion) {
        ArrayList<Ficha> lista = new ArrayList<>();
        for (int i = 0; i < fichas.size(); i++) {
            Ficha ficha = fichas.get(i);
            if (condicion.esCumplidaPor(ficha))
                lista.add(ficha);
        }
        return lista;
    }

    public double getDificultad() {
        return dificultad;
    }

    private void setDificultad() {
        double sumaFortalezas = 0;
        double sumaPoder = 0;
        for (int i = 0; i < fichas.size(); i++) {
            Ficha ficha = fichas.get(i);
            sumaFortalezas += ficha.getFortaleza();
            sumaPoder += ficha.getPoderDestruccion();
        }

        dificultad = sumaFortalezas / sumaPoder;
    }

    public String obtenerInformacion() {
        return  "TABLERO\n" +
                "Nivel " + nivel + "\n" +
                "Puntaje mínimo: " + puntajeMinimo + "\n" +
                "Dificultad: " + dificultad + "\n" +
                "Fichas: " + fichas;
    }

    @Override
    public boolean equals(Object o) {
        try {
            Tablero otroTablero = (Tablero) o;
            return this.getNivel() == otroTablero.getNivel();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Nivel " + nivel;
    }
}
