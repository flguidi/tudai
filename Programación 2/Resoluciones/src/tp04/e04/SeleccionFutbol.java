package tp04.e04;

import java.util.ArrayList;

public class SeleccionFutbol {
    // Atributos
    private String nombre;
    private ArrayList<Integrante> integrantes;

    // Constructores
    public SeleccionFutbol(String nombre) {
        this.nombre = nombre;
        this.integrantes = new ArrayList<>();
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Integrante> getIntegrantes() {
        return new ArrayList<>(this.integrantes);
    }

    public Integrante getIntegranteByPasaporte(String pasaporte) {
        for (Integrante integrante : integrantes) {
            if (integrante.getPasaporte().equals(pasaporte))
                return integrante;
        }
        return null;
    }

    public void agregarIntegrante(Integrante integrante) {
        if (!integrantes.contains(integrante))
            integrantes.add(integrante);
    }

    public void eliminarIntegrante(int indice) {
        if (indice >= 0 && indice < integrantes.size())
            integrantes.remove(indice);
    }
}
