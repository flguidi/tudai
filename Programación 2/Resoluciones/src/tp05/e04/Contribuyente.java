package tp05.e04;

public class Contribuyente {
    // Atributos
    private String nombre;
    private String idTributaria;
    private double montoFijo;

    // Constructores
    public Contribuyente(String nombre, String idTributaria, double montoFijo) {
        this.nombre = nombre;
        this.idTributaria = idTributaria;
        this.montoFijo = montoFijo;
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdTributaria() {
        return idTributaria;
    }

    public void setIdTributaria(String idTributaria) {
        this.idTributaria = idTributaria;
    }

    public double getMontoFijo() {
        return montoFijo;
    }

    public void setMontoFijo(double montoFijo) {
        this.montoFijo = montoFijo;
    }

    public double getImpuesto() {
        return this.montoFijo;
    }
}
