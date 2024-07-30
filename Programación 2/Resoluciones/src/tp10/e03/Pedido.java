package tp10.e03;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pedido {
    // Atributos
    private String material;
    private LocalDate fechaLimiteEntrega;
    private double costoFabricacion;
    private double precioVenta;
    private ArrayList<String> caracteristicas;

    // Constructores
    public Pedido(String material, LocalDate fechaLimiteEntrega, double costoFabricacion, double precioVenta) {
        this.material = material;
        this.fechaLimiteEntrega = fechaLimiteEntrega;
        this.costoFabricacion = costoFabricacion;
        this.precioVenta = precioVenta;
        this.caracteristicas = new ArrayList<>();
    }

    // Métodos
    public String getMaterial() {
        return material;
    }

    public LocalDate getFechaLimiteEntrega() {
        return fechaLimiteEntrega;
    }

    public double getCostoFabricacion() {
        return costoFabricacion;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public boolean tieneCaracteristica(String caracteristica) {
        return this.caracteristicas.contains(caracteristica);
    }

    public double calcularGanancia() {
        return this.getPrecioVenta() - this.getCostoFabricacion();
    }

    @Override
    public String toString() {
        return "Material: " + material + " | " +
                "Costo fabricación: " + costoFabricacion + " | " +
                "Precio venta: " + precioVenta;
    }
}
