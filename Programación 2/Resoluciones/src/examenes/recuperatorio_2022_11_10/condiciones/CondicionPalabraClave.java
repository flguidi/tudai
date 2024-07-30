package recuperatorio_2022_11_10.condiciones;

import recuperatorio_2022_11_10.Noticia;

public class CondicionPalabraClave extends Condicion {
    // Atributos
    private String palabraClaveBuscada;

    // Constructores
    public CondicionPalabraClave(String palabraClaveBuscada) {
        this.palabraClaveBuscada = palabraClaveBuscada;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Noticia noticia) {
        return noticia.tienePalabraClave(palabraClaveBuscada);
    }
}
