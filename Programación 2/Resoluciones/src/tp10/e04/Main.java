package tp10.e04;

import tp10.e04.condiciones.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // CARGA DE DATOS
        // Gastos simples
        GastoSimple<String> gs1 = new GastoSimple<>("Cimientos", LocalDate.of(2024, 8, 10), 3000);
        gs1.agregarCaracteristica("Calidad", "Alta");

        GastoSimple<String> gs2 = new GastoSimple<>("Pintura", LocalDate.of(2024, 10, 3), 1000);
        gs2.agregarCaracteristica("Calidad", "Media");

        GastoSimple<String> gs3 = new GastoSimple<>("Edificación", LocalDate.of(2024, 12, 15), 5000);
        gs3.agregarCaracteristica("Calidad", "Alta");

        // Gasto detallado
        GastoDetallado<String> gd = new GastoDetallado<>("Construcción edificio", LocalDate.of(2024, 12, 18));
        gd.agregarCaracteristica("Calidad", "Alta");
        gd.agregarGasto(gs1);
        gd.agregarGasto(gs2);
        gd.agregarGasto(gs3);

        // PRUEBA DE SERVICIOS
        // Listado de gasto detallado
        System.out.print(gd.listar(0));

        // Total de dinero gastado en una fecha dada
        LocalDate fecha = LocalDate.of(2024, 10, 3);
        System.out.print("\nTotal de dinero gastado en la fecha " + fecha + ": ");
        System.out.println(gd.calcularMontoEspecifico(new CondicionFecha<>(fecha)));

        // Búsqueda filtrada
        double monto = 1556;
        System.out.println("\nGastos que superan un monto de $" + monto + ":");
        System.out.println(gd.buscar(new CondicionMonto<>(monto)));

        System.out.println("\nGastos de calidad media:");
        System.out.println(gd.buscar(new CondicionCaracteristica<>("Calidad", "Media")));

        // Monto filtrado
        System.out.print("\nMonto total de gastos de calidad alta: ");
        System.out.println(gd.calcularMontoEspecifico(new CondicionCaracteristica<>("Calidad", "Alta")));

        // Gasto pendiente (se decora un gasto simple)
        double porcentaje = 0.02;
        int dias = 10;
        boolean estaPendiente = true;
        DecoradorGastoPendiente<String> gp = new DecoradorGastoPendiente<>(gs1, porcentaje, dias, estaPendiente);
        System.out.println("\nGasto con " + dias + " días pendientes y un porcentaje de " + porcentaje + ":");
        System.out.println(gp);
    }
}
