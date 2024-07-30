package tp06.e03;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Se instancia un puerto de cereales
        PuertoCereales puerto = new PuertoCereales();

        // Se instancian camiones y barcos
        Barco b1 = new Barco("b1", 2000);
        Barco b2 = new Barco("b2", 2500);
        Barco b3 = new Barco("b3", 1700);
        Camion c1 = new Camion("c1", LocalDate.of(2023, 9, 20), "Trigo");
        Camion c2 = new Camion("c2", LocalDate.of(2023, 10, 18), "Avena");
        Camion c3 = new Camion("c3", LocalDate.of(2023, 7, 16), "Maíz");

        // Se cargan barcos y descargan camiones
        puerto.cargarBarco(b1);
        puerto.cargarBarco(b2);
        System.out.println(puerto + "\n");

        puerto.descargarCamion(c1);
        System.out.println(puerto + "\n");

        puerto.descargarCamion(c2);
        puerto.descargarCamion(c3);
        System.out.println(puerto + "\n");
    }
}
