package tp08.e04;

/**
 * Encriptador utilizado por el decorador DecoradorEncriptacion.
 */
public class Encriptador {
    // Atributos
    private String clave;

    // Constructores
    public Encriptador(String clave) {
        this.clave = clave;
    }

    // Métodos (funcionalidades adicionales)
    public String encriptar(String original) {
        // Lógica para encriptar el texto original usando this.clave
        return original + " [ENCRIPTADO] ";
    }

    public String desencriptar(String encriptado) {
        // Lógica para desencriptar el texto encriptado usando this.clave
        return encriptado + " [DESENCRIPTADO] ";
    }
}
