package tp04.e05;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Se instancia una empresa avícola
        Avicola avicola = new Avicola("Avícola 'Los Hermanos'");

        // Se instancian productos
        LocalDate env1 = LocalDate.of(2023, 9, 9);
        LocalDate venc1 = LocalDate.of(2023, 10, 12);
        Producto productoFresco = new Producto("Huevos de gallina blancos", "Fresco", env1, venc1, 1234, "Los trigos");

        LocalDate env2 = LocalDate.of(2023, 9, 2);
        LocalDate venc2 = LocalDate.of(2023, 10, 5);
        ProductoRC productoRefrigerado = new ProductoRC("Milanesas de pollo", "Refrigerado", env2, venc2, 2345,
                "Los girasoles", 7, "R-001");

        LocalDate env3 = LocalDate.of(2023, 8, 28);
        LocalDate venc3 = LocalDate.of(2023, 9, 15);
        ProductoRC congeladoAire = new CongeladoAire("Papas fritas", "Congelado por aire", env3, venc3, 3456,
                "Los cedros", -60, "AI-001", 20, 13, 50);

        LocalDate env4 = LocalDate.of(2023, 9, 10);
        LocalDate venc4 = LocalDate.of(2023, 10, 25);
        ProductoRC congeladoAgua = new CongeladoAgua("Hamburguesas de carne", "Congelado por agua", env4, venc4, 4567,
                "Los ombúes", -50, "AG-001", 20);

        LocalDate env5 = LocalDate.of(2023, 9, 10);
        LocalDate venc5 = LocalDate.of(2023, 10, 25);
        ProductoRC congeladoNitrogeno = new CongeladoNitrogeno("Hamburguesa de pollo", "Congelado por nitrógeno",
                env5, venc5, 5678, "Los robles", -40, "NI-001", "Ultracongelación", 25);

        // Se agregan los productos
        avicola.agregarProducto(productoFresco);
        avicola.agregarProducto(productoRefrigerado);
        avicola.agregarProducto(congeladoAire);
        avicola.agregarProducto(congeladoAgua);
        avicola.agregarProducto(congeladoNitrogeno);

        // Se imprime el listado de productos
        avicola.imprimirListaProductos();
    }
}
