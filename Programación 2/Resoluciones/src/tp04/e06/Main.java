package tp04.e06;

public class Main {
    public static void main(String[] args) {
        // Se instancia un registro de empresa
        RegistroEmpresa registro = new RegistroEmpresa("Globant");

        // Se instancian personas asociadas
        Jerarquico jerarquico = new Jerarquico("Sofía", "Guzmán", 45, 12341234, 400000);
        Empleado empleado = new Empleado("Martina", "Fernández", 38, 12345678, 250000);
        UsuarioFinal usuario = new UsuarioFinal("Juan", "Pérez", 30, "juanperez", "1234");

        // Personal jerárquico agrega empleados
        jerarquico.agregarEmpleado(empleado);

        // Se agregan personas asociadas al registro
        registro.agregarPersonaAsociada(jerarquico);
        registro.agregarPersonaAsociada(empleado);
        registro.agregarPersonaAsociada(usuario);

        // Se imprime el listado de personas asociadas
        registro.imprimirListado();
    }
}
