package tp04.e01;

public class Main {
    public static void main(String[] args) {
        // Se crea una alarma
        Alarma alarma = new Alarma();
        AlarmaLuminosa alarmaLuminosa = new AlarmaLuminosa();

        // Se comprueba el estado de las alarmas
        alarma.comprobar();
        alarmaLuminosa.comprobar();

        // La alarma detecta un vidrio roto
        alarma.activarVidrioRoto();
        alarma.comprobar();

        // La alarma luminosa detecta un movimiento
        alarmaLuminosa.activarMovimientoDetectado();
        alarmaLuminosa.comprobar();
    }
}
