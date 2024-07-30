package tp05.e05;

public class Main {
    public static void main(String[] args) {
        // Se instancia una empresa
        Empresa empresa = new Empresa("La Serenísima");

        // Se instancian empleados y se agregan a la empresa
        Empleado e1 = new Empleado("Juan", "Pérez", "12.345.678", 100000);
        EmpleadoVendedor e2 = new EmpleadoVendedor("Martina", "Rodríguez", "23.456.789", 120000, 0.05);
        EmpleadoBonos e3 = new EmpleadoBonos("Pedro", "Domínguez", "34.567.890", 130000, 10000, 10);

        empresa.agregarEmpleado(e1);
        empresa.agregarEmpleado(e2);
        empresa.agregarEmpleado(e3);

        // Se agregan ventas a los vendedores
        e2.agregarMontoVentas(50000);
        e3.agregarVentas(12);

        // Se imprime información
        System.out.println(empresa);
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);
    }
}
