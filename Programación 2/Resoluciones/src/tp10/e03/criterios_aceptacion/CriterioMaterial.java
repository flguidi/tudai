package tp10.e03.criterios_aceptacion;

import tp10.e03.Pedido;

public class CriterioMaterial extends CriterioAceptacion {
    // Atributos
    private String material;

    // Constructores
    public CriterioMaterial(String material) {
        this.material = material;
    }

    // Métodos
    @Override
    public boolean acepta(Pedido pedido) {
        return pedido.getMaterial().equals(this.material);
    }
}
