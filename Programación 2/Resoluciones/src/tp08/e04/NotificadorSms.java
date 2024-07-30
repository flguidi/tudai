package tp08.e04;

/**
 * Representa un COMPONENTE CONCRETO del patrón Decorator, que implementa el componente base Notificador.
 */
public class NotificadorSms implements Notificador {
    // Atributos
    private String numeroTelefono;

    // Constructores
    public NotificadorSms (String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
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
