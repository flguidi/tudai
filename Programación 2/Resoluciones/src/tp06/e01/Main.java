package tp06.e01;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Se instancia un sistema de alquiler
        SistemaAlquiler sistemaAlquiler = new SistemaAlquiler();

        // Se instancian clientes y productos, y se agregan al sistema
        Cliente cliente1 = new Cliente("Juan", "Pérez", 12345678);
        Cliente cliente2 = new Cliente("Sofía", "Rodríguez", 23456789);
        Producto vehiculo = new Vehiculo("Toyota", "Corolla", "ABC123", "Naftero", 1400, LocalDate.of(2023, 9, 30));
        Producto pelicula = new Pelicula("El padrino", "Francis Coppola", 1, LocalDate.of(2023, 8, 15));

        sistemaAlquiler.agregarCliente(cliente1);
        sistemaAlquiler.agregarCliente(cliente2);
        sistemaAlquiler.agregarProducto(vehiculo);
        sistemaAlquiler.agregarProducto(pelicula);

        // Alquiler de vehículos
        sistemaAlquiler.alquilar(vehiculo, cliente2);
        sistemaAlquiler.alquilar(vehiculo, cliente1); // Ya está alquilado el auto

        // Alquiler de películas
        sistemaAlquiler.alquilar(pelicula, cliente1);
        sistemaAlquiler.alquilar(pelicula, cliente2); // No se puede alquilar porque ya no quedan copias

        // Se muestran datos de los clientes
        System.out.println(cliente1);
        System.out.println(cliente2);

        // Se verifica qué clientes tienen alquileres vencidos
        System.out.println("\nClientes con alquileres vencidos: ");
        String listaClientes = sistemaAlquiler.getClientesAlquileresVencidos();
        System.out.println(listaClientes);
    }
}
