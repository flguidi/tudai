package recuperatorio_2022_11_10.condiciones;

import recuperatorio_2022_11_10.Noticia;

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
        return noticia.getCategoria().contains(categoriaBuscada);
    }
}
