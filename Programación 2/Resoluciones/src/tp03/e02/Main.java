package tp03.e02;

public class Main {
    public static final double MARGEN_BENEFICIO = 0.35;

    public static void main(String[] args) {
        // Se instancia una fábrica de muebles
        FabricaMuebles fabrica = new FabricaMuebles("Fábrica de Muebles Tandil");

        // Se crean muebles (sillas, bancos y mesas)
        Mueble silla1 = new Mueble("Silla", 5, 4200, MARGEN_BENEFICIO, "Pino", "Blanco");
        Mueble banco1 = new Mueble("Banco", 15, 8400, MARGEN_BENEFICIO, "Pino", "Blanco");
        Mueble mesa1 = new Mueble("Mesa", 27, 20000, MARGEN_BENEFICIO, "Pino", "Blanco");

        Mueble silla2 = new Mueble("Mesa", 7, 12000, MARGEN_BENEFICIO, "Roble", "Natural");
        Mueble banco2 = new Mueble("Mesa", 20, 24000, MARGEN_BENEFICIO, "Roble", "Natural");
        Mueble mesa2 = new Mueble("Mesa", 40, 70000, MARGEN_BENEFICIO, "Roble", "Natural");

        // Se agregan los muebles al stock de la fábrica
        fabrica.agregarProductoStock(silla1);
        fabrica.agregarProductoStock(banco1);
        fabrica.agregarProductoStock(mesa1);
        fabrica.agregarProductoStock(silla2);
        fabrica.agregarProductoStock(banco2);
        fabrica.agregarProductoStock(mesa2);

        // Se imprimen todos los datos de la fábrica (nombre, cantidad de productos y stock)
        System.out.println(fabrica);

        // Se calcula el precio de fabricación y valor de venta de un producto dado
        int i = 0;
        double costoFabricacion = fabrica.getCostoFabricacion(i);
        double valorVenta = fabrica.getValorVenta(i);
        System.out.println("Producto " + i + ": ");
        System.out.println("Costo de fabricación: " + costoFabricacion);
        System.out.println("Valor de venta: " + valorVenta);
    }
}
