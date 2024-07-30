package tp10.e02;

import tp10.e02.criterios_prediccion.*;

public class Main {
    public static void main(String[] args) {
        // Estación meteorológica
        EstacionMeteorologica e1 = new EstacionMeteorologica("Nueva York");

        // Sensores y registros
        Sensor s1 = new Sensor("Lluvia", new CriterioPromedio(110, 3));
        s1.registrarDato(110);
        s1.registrarDato(120);
        s1.registrarDato(108);
        e1.agregarSensor(s1);

        Sensor s2 = new Sensor("Temperatura", new CriterioMaximoValor(24, 4));
        s2.registrarDato(25);
        s2.registrarDato(24);
        s2.registrarDato(27);
        s2.registrarDato(28);
        e1.agregarSensor(s2);

        System.out.println("¿Lloverá en " + e1.getCiudad() + "? " + e1.predecirLluvia());
    }
}
