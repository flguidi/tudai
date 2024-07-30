package tp09.e07;

import tp09.e07.condiciones.*;

public class Main {
    public static void main(String[] args) {
        // CARGA DE DATOS
        // Se instancian productos
        Producto p1 = new Producto("Sartén antiadherente", 2500, 2000);
        p1.agregarCategoria("Cocina");
        Producto p2 = new Producto("Espátula de silicona", 600, 200);
        p2.agregarCategoria("Cocina");
        Producto p3 = new Producto("Platos de cerámica x4", 3000, 4000);
        p3.agregarCategoria("Cocina");

        // Se instancian combos y se les agregan productos
        Combo c1 = new Combo("Set de cocina", 0.1, 100);
        c1.setCondIncorporacion(new CondicionCategoria("Cocina"));
        c1.agregarElemento(p1);
        c1.agregarElemento(p2);

        Combo c2 = new Combo("Vajilla", 0.1, 100);
        c2.setCondIncorporacion(new CondicionCategoria("Cocina"));
        c2.agregarElemento(p3);
        c1.agregarElemento(c2);

        // PRUEBA DE SERVICIOS
        System.out.print(c1.listar(0)); // Listado
        System.out.println("Precio: " + c1.getPrecio()); // Precio
        System.out.println("Peso: " + c1.getPeso()); // Peso
        System.out.println("Categorías: " + c1.getCategorias()); // Categorías
        System.out.println("Cantidad de productos: " + c1.cantidadProductos()); // Cantidad de productos

        // Búsqueda
        int precio = 2600;
        System.out.print("Productos con precio menor que $" + precio + ": ");
        System.out.println(c1.buscar(new CondicionPrecio(precio)));
    }
}
