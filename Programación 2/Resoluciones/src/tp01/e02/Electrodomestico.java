package tp01.e02;

public class Electrodomestico {
    // Atributos
    private String nombre;
    private double precioBase;
    private String color;
    private double consumoEnergetico;
    private double peso;

    // Constructores
    public Electrodomestico(String nombre) {
        this.nombre = nombre;
        this.color = "Gris plata";
        this.consumoEnergetico = 10;
        this.precioBase = 100;
        this.peso = 2;
    }

    public Electrodomestico(String nombre, double precioBase) {
        this(nombre);
        this.precioBase = precioBase;
    }

    public Electrodomestico(String nombre, double precioBase, String color) {
        this(nombre, precioBase);
        this.color = color;
    }

    public Electrodomestico(String nombre, double precioBase, String color, double consumoEnergetico) {
        this(nombre, precioBase, color);
        this.consumoEnergetico = consumoEnergetico;
    }

    public Electrodomestico(String nombre, double precioBase, String color, double consumoEnergetico, double peso) {
        this(nombre, precioBase, color, consumoEnergetico);
        this.peso = peso;
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public void setConsumoEnergetico(double consumoEnergetico) {
        this.consumoEnergetico = consumoEnergetico;
    }

    public boolean esDeBajoConsumo() {
        return consumoEnergetico < 45;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public boolean esDeAltaGama() {
        return calcularBalance() > 3;
    }

    public double calcularBalance() {
        return precioBase / peso;
    }
}
