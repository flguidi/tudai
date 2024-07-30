package tp08.e04;

/**
 * Representa un COMPONENTE CONCRETO del patrón Decorator, que implementa el componente base Notificador.
 */
public class NotificadorEmail implements Notificador {
    // Atributos
    private String emailEnvio;
    private String emailRecepcion;

    // Constructores
    public NotificadorEmail(String emailEnvio, String emailRecepcion) {
        this.emailEnvio = emailEnvio;
        this.emailRecepcion = emailRecepcion;
    }

    // Métodos
    @Override
    public void enviarNotificacion(String s) {
        System.out.println("Notificación enviada: " + s);
    }

    @Override
    public String obtenerNotificacion() {
        return "Notificación recibida";
    }
}
