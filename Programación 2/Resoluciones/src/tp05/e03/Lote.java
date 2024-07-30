package tp05.e03;

import java.util.ArrayList;

public class Lote {
    // Atributos
    private String identificador;
    private int hectareas;
    private ArrayList<String> minerales;

    // Constructores
    public Lote(String identificador, int hectareas) {
        this.identificador = identificador;
        this.hectareas = hectareas;
        this.minerales = new ArrayList<>();
    }

    // Métodos
    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public int getHectareas() {
        return hectareas;
    }

    public void setHectareas(int hectareas) {
        this.hectareas = hectareas;
    }

    public void agregarMineral(String mineral) {
        if (!this.minerales.contains(mineral))
            this.minerales.add(mineral);
    }

    public void eliminarMineral(String mineral) {
        this.minerales.remove(mineral);
    }

    public boolean tieneMineral(String mineral) {
        return this.minerales.contains(mineral);
    }

    public boolean sePuedeSembrar(Cereal cereal) {
        return cereal.sePuedeSembrarEn(this);
    }
}
