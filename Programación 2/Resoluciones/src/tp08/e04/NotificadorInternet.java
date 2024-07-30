package tp08.e04;

/**
 * Representa un COMPONENTE CONCRETO del patrón Decorator, que implementa el componente base Notificador.
 */
public class NotificadorInternet implements Notificador {
    // Atributos
    private String mensaje;

    // Constructores
    public NotificadorInternet(String mensaje) {
        this.mensaje = mensaje;
    }

    // Métodos
    @Override
    public void enviarNotificacion(String s) {
        System.out.println("Notificación enviada: " + s);
    }

    @Override
    public String obtenerNotificacion() {
        return "Notificación recibida.";
    }
}
