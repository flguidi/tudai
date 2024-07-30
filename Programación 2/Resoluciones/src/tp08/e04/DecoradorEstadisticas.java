package tp08.e04;

/**
 * Representa un DECORADOR CONCRETO del patrón Decorator, que agrega funcionalidad adicional a los
 * componentes concretos.
 */
public class DecoradorEstadisticas extends DecoradorNotificador {
    // Atributos
    private int mensajesEnviados;
    private int mensajesRecibidos;

    // Constructores
    public DecoradorEstadisticas(Notificador notificador) {
        super(notificador);
        this.mensajesEnviados = 0;
        this.mensajesRecibidos = 0;
    }

    // Métodos
    @Override
    public void enviarNotificacion(String s) {
        super.enviarNotificacion(s);
        mensajesEnviados++;
    }

    @Override
    public String obtenerNotificacion() {
        mensajesRecibidos++;
        return super.obtenerNotificacion();
    }

    @Override
    protected String modificarMensaje(String s) {
        return s;
    }

    @Override
    protected String desmodificarMensaje(String s) {
        return s;
    }

    public void imprimirEstadisticas() {
        System.out.println("Mensajes enviados: " + mensajesEnviados);
        System.out.println("Mensajes recibidos: " + mensajesRecibidos);
    }
}
