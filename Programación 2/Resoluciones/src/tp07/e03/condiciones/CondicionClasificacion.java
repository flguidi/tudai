package tp07.e03.condiciones;

import tp07.e03.Planta;

public class CondicionClasificacion extends Condicion {
    // Atributos
    private String clasSuperior;

    // Constructores
    public CondicionClasificacion(String clasSuperior) {
        this.clasSuperior = clasSuperior;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Planta planta) {
        return planta.getClasificacionSuperior().equals(clasSuperior);
    }
}
