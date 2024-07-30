package tp07.e02.condiciones;

import tp07.e02.Documento;

public class CondicionContenidoMin extends Condicion {
    // Atributos
    private int cantidadPalabras;

    // Constructores
    public CondicionContenidoMin(int cantidadPalabras) {
        this.cantidadPalabras = cantidadPalabras;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Documento documento) {
        int cantidadPalabrasContenido = documento.getContenido().split(" ").length;
        return cantidadPalabrasContenido >= cantidadPalabras;
    }
}
