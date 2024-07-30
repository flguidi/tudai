package tp03.e03;

import java.util.ArrayList;

public class Personaje {
    // Atributos
    private String tipo;
    private String nombreReal;
    private String nombreSuperheroe;
    private ArrayList<Caracteristica> caracteristicas;
    private boolean elegido;

    // Constructores
    public Personaje(String tipo, String nombreReal, String nombreSuperheroe) {
        this.tipo = tipo;
        this.nombreReal = nombreReal;
        this.nombreSuperheroe = nombreSuperheroe;
        this.caracteristicas = new ArrayList<>();
        this.elegido = false;
    }

    // Métodos
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombreReal() {
        return nombreReal;
    }

    public void setNombreReal(String nombreReal) {
        this.nombreReal = nombreReal;
    }

    public String getNombreSuperheroe() {
        return nombreSuperheroe;
    }

    public void setNombreSuperheroe(String nombreSuperheroe) {
        this.nombreSuperheroe = nombreSuperheroe;
    }

    public boolean isElegido() {
        return elegido;
    }

    public void setElegido(boolean elegido) {
        this.elegido = elegido;
    }

    public void agregarCaracteristica(Caracteristica caracteristica) {
        this.caracteristicas.add(caracteristica);
    }

    public void eliminarCaracteristica(int indice) {
        if (indice >= 0 && indice < this.caracteristicas.size())
            this.caracteristicas.remove(indice);
    }

    public int getValorCaracteristica(String nombre) {
        for (Caracteristica caracteristica : caracteristicas) {
            if (caracteristica.getNombre().equalsIgnoreCase(nombre))
                return caracteristica.getValor();
        }

        System.out.println("Característica no encontrada");
        return 0;
    }
}
