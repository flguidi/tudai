package parcial_2022_10_26.condiciones;

import parcial_2022_10_26.Noticia;

public class CondicionCategoria extends Condicion {
    // Atributos
    private String categoriaBuscada;

    // Constructores
    public CondicionCategoria(String categoriaBuscada) {
        this.categoriaBuscada = categoriaBuscada;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Noticia noticia) {
        return noticia.getCategoria().equalsIgnoreCase(categoriaBuscada);
    }
}
