package tp07.e03.condiciones;

import tp07.e03.Planta;

public class CondicionRiego extends Condicion {
    // Atributos
    private int riegoMinimo;

    // Constructores
    public CondicionRiego(int riegoMinimo) {
        this.riegoMinimo = riegoMinimo;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Planta planta) {
        return planta.getAguaRequerida() > riegoMinimo;
    }
}
