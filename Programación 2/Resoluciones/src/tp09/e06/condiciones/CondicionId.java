package tp09.e06.condiciones;

import tp09.e06.ElementoSimple;

public class CondicionId extends Condicion {
    // Atributos
    private String id;

    // Constructores
    public CondicionId(String id) {
        this.id = id;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(ElementoSimple elemento) {
        return elemento.getId().equals(this.id);
    }
}
