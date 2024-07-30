package tp03.e02;

public class Mueble {
    // Atributos
    private String tipo;
    private double peso;
    private double costoFabricacion;
    private double valorVenta;
    private String tipoMadera;
    private String color;

    // Constructores
    public Mueble(String tipo, double peso, double costoFabricacion, double margenBeneficio,
                  String tipoMadera, String color) {
        this.tipo = tipo;
        this.peso = peso;
        this.costoFabricacion = costoFabricacion;
        this.valorVenta = calcularValorVenta(margenBeneficio);
        this.tipoMadera = tipoMadera;
        this.color = color;
    }

    // Métodos
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getCostoFabricacion() {
        return costoFabricacion;
    }

    public void setCostoFabricacion(double costoFabricacion, double margenBeneficio) {
        this.costoFabricacion = costoFabricacion;
        this.valorVenta = calcularValorVenta(margenBeneficio);
    }

    public double calcularValorVenta(double margenBeneficio) {
        return this.costoFabricacion * (1 + margenBeneficio);
    }

    public String getTipoMadera() {
        return tipoMadera;
    }

    public void setTipoMadera(String tipoMadera) {
        this.tipoMadera = tipoMadera;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "|MUEBLE| " +
                "Tipo: " + this.tipo + " - " +
                "Peso: " + this.peso + "kg - " +
                "Costo de fabricación: $" + this.costoFabricacion + " - " +
                "Valor de venta: $" + this.valorVenta + " - " +
                "Tipo madera: " + this.tipoMadera + " - " +
                "Color: " + this.color;
    }
}
