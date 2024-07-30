package tp08.e04;

/**
 * Representa un DECORADOR CONCRETO del patrón Decorator, que agrega funcionalidad adicional a los
 * componentes concretos.
 */
public class DecoradorCompresion extends DecoradorNotificador {
    public DecoradorCompresion(Notificador notificador) {
        super(notificador);
    }

    @Override
    protected String modificarMensaje(String s) {
        return Gzip.comprimir(s);
    }

    @Override
    protected String desmodificarMensaje(String s) {
        return Gzip.descomprimir(s);
    }
}
