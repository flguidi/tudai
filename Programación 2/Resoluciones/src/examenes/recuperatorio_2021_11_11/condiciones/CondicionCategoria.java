package recuperatorio_2021_11_11.condiciones;

import recuperatorio_2021_11_11.ElementoBazar;

public class CondicionCategoria extends Condicion {
    // Atributos
    private String categoriaBuscada;

    // Constructores
    public CondicionCategoria(String categoriaBuscada) {
        this.categoriaBuscada = categoriaBuscada;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(ElementoBazar elemento) {
        return elemento.tieneCategoria(categoriaBuscada);
    }
}
