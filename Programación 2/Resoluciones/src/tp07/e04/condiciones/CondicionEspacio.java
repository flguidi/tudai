package tp07.e04.condiciones;

import tp07.e04.Ficha;

public class CondicionEspacio extends Condicion {
    // Atributos
    private int espacio;

    // Constructores
    public CondicionEspacio(int espacio) {
        this.espacio = espacio;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Ficha ficha) {
        return ficha.getEspacio() > espacio;
    }
}
