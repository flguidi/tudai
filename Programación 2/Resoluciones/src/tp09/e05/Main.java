package tp09.e05;

import tp09.e05.comparadores.*;
import tp09.e05.condiciones.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // CARGA DE DATOS
        // Seguros simples
        SeguroSimple s1 = new SeguroSimple(12345678, 1234, "Automotor", 1200);
        SeguroSimple s2 = new SeguroSimple(12345678, 1235, "De vida", 3000);

        // Seguro temporal
        LocalDate fInicio = LocalDate.of(2024, 7, 1);
        LocalDate fFin = LocalDate.of(2024, 8, 1);
        SeguroTemporal s3 = new SeguroTemporal(12345678, 1236, "Hogar (Temporal)", 2000, fInicio, fFin);

        // Seguro integrador
        SeguroIntegrador sIntegrador = new SeguroIntegrador(12345678);
        sIntegrador.agregarSeguro(s1);
        sIntegrador.agregarSeguro(s2);
        sIntegrador.agregarSeguro(s3);

        // PRUEBA DE SERVICIOS
        // Monto asegurado
        System.out.println("Monto asegurado: " + sIntegrador.getMontoAsegurado());

        // Número de póliza
        System.out.println("Número de póliza: " + sIntegrador.getNumeroPoliza());

        // Búsquedas ordenadas con filtro
        SeguroSimple s4 = new SeguroSimple(12345678, 345, "Hogar", 5000);
        sIntegrador.agregarSeguro(s4);

        String palabraClave = "Hogar";
        System.out.print("Seguros con palabra '" + palabraClave + "': ");

        Condicion condDescripcion = new CondicionDescripcion(palabraClave);
        ComparadorDni compDni = new ComparadorDni();
        ComparadorNumPoliza compPoliza = new ComparadorNumPoliza();
        ComparadorCompuesto compCompuesto = new ComparadorCompuesto(compDni, compPoliza);

        System.out.println(sIntegrador.buscar(condDescripcion, compCompuesto));

        // Calculador de costos
        s1.setCalculadorCosto(new CalculadorMontoFijo(1000));
        s2.setCalculadorCosto(new CalculadorMontoFijo(2000));
        s3.setCalculadorCosto(new CalculadorPorcentaje(0.2, s3.getMontoAsegurado()));
        System.out.println("Costo: " + sIntegrador.calcularCosto());
    }
}
