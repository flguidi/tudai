package tp10.e03;

import tp10.e03.comparadores.*;
import tp10.e03.criterios_aceptacion.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Se instancia una fábrica y se agregan criterios de aceptación y ordenamiento
        Fabrica fabrica = new Fabrica();
        fabrica.setCriterioAceptacion(new CriterioMaterial("Pino"));
        fabrica.setCriterioOrdenamiento(new ComparadorGanancia());

        // Se instancian pedidos
        Pedido pPino1 = new Pedido("Pino", LocalDate.now(), 1000, 2000);
        Pedido pPino2 = new Pedido("Pino", LocalDate.now(), 1200, 1800);
        Pedido pRoble = new Pedido("Roble", LocalDate.now(), 3000, 5000);

        // 1. Aceptación de pedidos
        System.out.println("¿Acepta pedido de pino 1? " + fabrica.aceptaPedido(pPino1));
        System.out.println("¿Acepta pedido de pino 2? " + fabrica.aceptaPedido(pPino2));

        // 2. Se agregan pedidos a la fábrica
        fabrica.agregarPedido(pPino1);
        fabrica.agregarPedido(pPino2);
        System.out.print("Cola de pedidos:\n" + fabrica.listarPedidos());

        // Cambio dinámico de criterio de aceptación
        System.out.println("\n¿Acepta pedido de roble? " + fabrica.aceptaPedido(pRoble)); // No acepta este pedido
        fabrica.agregarPedido(pRoble); // Y no lo agrega
        System.out.print("Cola de pedidos:\n" + fabrica.listarPedidos());

        fabrica.setCriterioAceptacion(new CriterioMaterial("Roble")); // Se cambia el criterio
        System.out.println("\n¿Ahora lo acepta? " + fabrica.aceptaPedido(pRoble)); // Ahora sí lo acepta
        fabrica.agregarPedido(pRoble); // Y lo agrega
        System.out.print("Cola de pedidos con pedido de roble:\n" + fabrica.listarPedidos());

        // 3. Ganancia esperada de la fábrica
        System.out.println("\nGanancia esperada: " + fabrica.calcularGananciaTotal());

        // 4. Se cambia dinámicamente el criterio de ordenamiento y se reordena la cola de pedidos
        fabrica.setCriterioOrdenamiento(new ComparadorCosto());
        System.out.print("\nCola de pedidos ordenada por costo:\n" + fabrica.listarPedidos());
    }
}
