package tp10.e05;

import tp10.e05.condiciones.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // CARGA DE DATOS
        // Paquetes
        Paquete p1 = new Paquete("P-001", "Ciudad A", LocalDate.of(2024, 10, 5), 1000, 200);
        Paquete p2 = new Paquete("P-002", "Ciudad A", LocalDate.of(2024, 7, 17), 1200, 500);
        Paquete p3 = new Paquete("P-003", "Ciudad B", LocalDate.of(2024, 10, 5), 2000, 700);
        Paquete p4 = new Paquete("P-004", "Ciudad A", LocalDate.of(2024, 10, 5), 3000, 800);

        // Combo
        Combo c = new Combo("C-001", "Ciudad A", LocalDate.of(2024, 10, 5));
        c.agregarElemento(p1);
        c.agregarElemento(p2); // No se agrega (distinta fecha)
        c.agregarElemento(p3); // No se agrega (distinto destino)
        c.agregarElemento(p4);

        System.out.println(c.listar(0));

        // PRUEBA DE SERVICIOS
        // Costo de envío
        System.out.println("Costo de envío de " + c + ": " + c.getCostoEnvio());

        // Valor asegurado
        System.out.println("Valor asegurado de " + c + ": " + c.getValorAsegurado());

        // Paquete con mayor valor asegurado
        System.out.println("Paquete con mayor valor asegurado de " + c + ": "
                + c.getPaqueteMayorValorAsegurado());

        // Búsqueda
        Condicion cDestino = new CondicionDestino("Ciudad A");
        String destino = "Ciudad 1";
        System.out.println("\nPaquetes con destino a " + destino + ": " + c.buscar(cDestino));

        // Copia
        Combo copia = (Combo) c.copiar();
        copia.eliminarElemento(p1);
        Paquete p5 = new Paquete("P-005", "Ciudad A", LocalDate.of(2024, 7, 17), 4000, 400);
        copia.agregarElemento(p5);

        System.out.println("\nCopia modificada de " + c + ":");
        System.out.println(copia.listar(0));
        System.out.println("El combo original no fue modificado:\n" + c.listar(0));

        // Combo especial
        ComboEspecial ce = new ComboEspecial("CE-001", "Ciudad B", LocalDate.of(2024, 3, 8));
        ce.setPoliticaAceptacion(new CondicionPrecioEnvio(3000));

        ce.agregarElemento(p1);
        ce.agregarElemento(p2);
        ce.agregarElemento(p3);
        ce.agregarElemento(p4); // No se agrega (Costo de envío mayor que $3000)

        System.out.println("Combo especial:\n" + ce.listar(0));

        // Combo promocional
        ComboPromocional cp = new ComboPromocional("CP-001", "Ciudad A", LocalDate.of(2024, 7, 17));
        cp.agregarElemento(p2);
        cp.agregarElemento(p5);

        System.out.println("Combo promocional:\n" + cp.listar(0));
    }
}
