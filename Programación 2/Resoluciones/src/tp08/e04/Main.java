package tp08.e04;

public class Main {
    public static void main(String[] args) {
        // Notificador base
        Notificador email = new NotificadorEmail("envio@empresa.com", "recepcion@usuario.com");

        // DECORADORES
        // Se añade decorador de compresión
        Notificador eComprimido = new DecoradorCompresion(email);

        // Se añade decorador de encriptación
        Notificador eComprimidoEncriptado = new DecoradorEncriptacion(eComprimido, new Encriptador("clave-secreta"));

        // Se añade decorador de estadísticas
        Notificador eComprimidoEncriptadoConEstadisticas = new DecoradorEstadisticas(eComprimidoEncriptado);

        // Se prueba el sistema de notificaciones
        eComprimidoEncriptadoConEstadisticas.enviarNotificacion("'Mensaje importante'");
        System.out.println(eComprimidoEncriptadoConEstadisticas.obtenerNotificacion());
        ((DecoradorEstadisticas) eComprimidoEncriptadoConEstadisticas).imprimirEstadisticas();
    }
}
