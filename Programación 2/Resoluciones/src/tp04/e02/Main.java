package tp04.e02;

public class Main {
    public static void main(String[] args) {
        // Se instancian sensores
        Sensor sensorLiving = new Sensor("Living");
        Sensor sensorCocina = new Sensor("Cocina");
        Sensor sensorHabitacion = new Sensor("Habitación");

        // Se instancian alarmas (una sensorial y otra luminosa)
        AlarmaSensorial alarmaS = new AlarmaSensorial();
        AlarmaLuminosa alarmaL = new AlarmaLuminosa();

        // Se agregan los sensores a las alarmas
        alarmaS.agregarSensor(sensorLiving);
        alarmaS.agregarSensor(sensorCocina);
        alarmaS.agregarSensor(sensorHabitacion);

        alarmaL.agregarSensor(sensorLiving);
        alarmaL.agregarSensor(sensorCocina);
        alarmaL.agregarSensor(sensorHabitacion);

        // Se hacen pruebas
        sensorLiving.activarMovimientoDetectado();
        sensorCocina.activarVidrioRoto();
        sensorHabitacion.activarPuertaVentanaAbierta();

        alarmaS.comprobar();
        alarmaL.comprobar();
    }
}
