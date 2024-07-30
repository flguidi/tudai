package tp09.e06;

import tp09.e06.calculadores_costo.*;
import tp09.e06.comparadores.*;
import tp09.e06.condiciones.*;

public class Main {
    public static void main(String[] args) {
        // CARGA DE DATOS
        // Se instancian elementos
        ElementoSimple e1 = new ElementoSimple("T-001", "Pala (Herramienta de trabajo)", 500, 3);
        ElementoSimple e2 = new ElementoSimple("T-002", "Balde (Herramienta de trabajo)", 400, 2);
        ElementoDeprecated e3 = new ElementoDeprecated("T-003", "Pico (Herramienta de trabajo)", 800, 7, 6, 0.5);

        // Se crea un combo y se agregan los elemementos
        Combo c1 = new Combo("C-001");
        c1.agregarElemento(e1);
        c1.agregarElemento(e2);
        c1.agregarElemento(e3);

        // PRUEBA DE SERVICIOS
        // Valor
        System.out.println("Valor del combo: " + c1.getValor());

        // Antigüedad
        System.out.println("Antigüedad del combo: " + c1.getAntiguedad());

        // Búsquedas
        ElementoSimple e4 = new ElementoSimple("T-004", "Destornillador (Herramienta de trabajo)", 600, 6);
        c1.agregarElemento(e4);

        // Condición de búsqueda
        String palabraClave = "trabajo";
        CondicionDescripcion condDescripcion = new CondicionDescripcion(palabraClave);

        // Comparadores para ordenar el resultado
        ComparadorId compId = new ComparadorId();
        ComparadorAntiguedad compAntiguedad = new ComparadorAntiguedad();
        ComparadorCompuesto compCompuesto = new ComparadorCompuesto(compId, compAntiguedad);

        System.out.print("Elementos con palabra clave '" + palabraClave + "': ");
        System.out.println(c1.buscar(condDescripcion, compCompuesto));

        // Calculadores de costos
        CalculadorCostoFijo cCostoFijo = new CalculadorCostoFijo(1000);
        CalculadorPorcentaje cPorcentaje = new CalculadorPorcentaje(e1.getValor(), 0.5);
        CalculadorCompuesto cCompuesto = new CalculadorCompuesto(cCostoFijo, cPorcentaje);
        e1.setCalculadorCosto(cPorcentaje);
        e2.setCalculadorCosto(cCostoFijo);
        e3.setCalculadorCosto(cCostoFijo);
        e4.setCalculadorCosto(cCompuesto);

        System.out.println("Costo de alquiler de " + e1 + ": " + e1.calcularCosto());
        System.out.println("Costo de alquiler de " + c1 + ": " + c1.calcularCosto());
    }
}
