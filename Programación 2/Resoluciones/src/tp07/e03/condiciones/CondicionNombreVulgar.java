package tp07.e03.condiciones;

import tp07.e03.Planta;

public class CondicionNombreVulgar extends Condicion {
    // Atributos
    private String nombreVulgar;

    // Constructores
    public CondicionNombreVulgar(String nombreVulgar) {
        this.nombreVulgar = nombreVulgar;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Planta planta) {
        return planta.tieneNombreVulgar(nombreVulgar);
    }
}
