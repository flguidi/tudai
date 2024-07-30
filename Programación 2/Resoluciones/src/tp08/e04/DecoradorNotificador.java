package tp08.e04;

/**
 * Representa el DECORADOR ABSTRACTO del patrón Decorator, que implementa la interfaz Notificador.
 */
public abstract class DecoradorNotificador implements Notificador {
    // Atributos
    protected Notificador notificador;

    // Constructores
    public DecoradorNotificador(Notificador notificador) {
        this.notificador = notificador;
    }

    // Métodos
    @Override
    public void enviarNotificacion(String s) {
        String mensajeModificado = modificarMensaje(s);
        notificador.enviarNotificacion(mensajeModificado);
    }

    @Override
    public String obtenerNotificacion() {
        String notificacion = notificador.obtenerNotificacion();
        return desmodificarMensaje(notificacion);
    }

    protected abstract String modificarMensaje(String s);

    protected abstract String desmodificarMensaje(String s);
}
