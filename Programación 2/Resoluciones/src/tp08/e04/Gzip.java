package tp08.e04;

/**
 * Compresor utilizado por el decorador DecoradorCompresion.
 */
public class Gzip {
    // Métodos (funcionalidades adicionales)
    public static String comprimir(String original) {
        // Lógica para comprimir el texto original
        return original + " [COMPRIMIDO] ";
    }

    public static String descomprimir(String comprimido) {
        // Lógica para descomprimir el texto comprimido
        return comprimido + " [DESCOMPRIMIDO] ";
    }
}
