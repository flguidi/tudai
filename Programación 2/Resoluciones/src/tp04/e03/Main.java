package tp04.e03;

public class Main {
    public static final double SUELDO_FIJO = 200000;

    public static void main(String[] args) {
        // Se instancian empleados
        EmpleadoContratado empleado1 = new EmpleadoContratado("Juan Pérez", 1234, SUELDO_FIJO);
        EmpleadoHorasExtras empleado2 = new EmpleadoHorasExtras("Pedro Gómez", 2345, SUELDO_FIJO, 5000);
        EmpleadoComision empleado3 = new EmpleadoComision("Martina González", 3456, SUELDO_FIJO, .2);

        // Se instancia una empresa y se agregan los empleados
        Empresa empresa = new Empresa("Globant");
        empresa.agregarEmpleado(empleado1);
        empresa.agregarEmpleado(empleado2);
        empresa.agregarEmpleado(empleado3);

        // Se añaden horas extras a empleado2
        empleado2.setHorasExtras(10);

        // Se añaden ventas a empleado3
        empleado3.registrarVenta(5000);
        empleado3.registrarVenta(10000);

        // Se obtienen los empleados por su número de ID y se imprimen sus datos
        System.out.println(empresa.getEmpleadoById(1234));
        System.out.println(empresa.getEmpleadoById(2345));
        System.out.println(empresa.getEmpleadoById(3456));
    }
}
