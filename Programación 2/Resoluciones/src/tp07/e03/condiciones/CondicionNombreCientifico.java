package tp07.e03.condiciones;

import tp07.e03.Planta;

public class CondicionNombreCientifico extends Condicion {
    // Atributos
    private String nombreCientifico;

    // Constructores
    public CondicionNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Planta planta) {
        return planta.getNombreCientifico().contains(nombreCientifico);
    }
}
