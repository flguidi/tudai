package tp08.e04;

/**
 * Representa un DECORADOR CONCRETO del patrón Decorator, que agrega funcionalidad adicional a los
 * componentes concretos.
 */
public class DecoradorEncriptacion extends DecoradorNotificador {
    // Atributos
    private Encriptador encriptador;

    // Constructores
    public DecoradorEncriptacion(Notificador notificador, Encriptador encriptador) {
        super(notificador);
        this.encriptador = encriptador;
    }

    // Métodos
    @Override
    protected String modificarMensaje(String s) {
        return encriptador.encriptar(s);
    }

    @Override
    protected String desmodificarMensaje(String s) {
        return encriptador.desencriptar(s);
    }
}
