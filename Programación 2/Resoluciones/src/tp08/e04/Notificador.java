package tp08.e04;

/**
 * Representa el COMPONENTE BASE del patrón Decorator, definiendo la interfaz para los objetos que pueden tener
 * responsabilidades añadidas dinámicamente.
 */
public interface Notificador {
    /**
     * Envía una notificación con un texto dado.
     * @param s Mensaje de la notificación
     */
    void enviarNotificacion(String s);

    /**
     * Recupera una notificación.
     * @return Mensaje de la notificación
     */
    String obtenerNotificacion();
}
