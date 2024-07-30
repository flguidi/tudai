package tp06.e01;

import java.time.LocalDate;

public class Vehiculo extends Producto {
    // Atributos
    private String marca;
    private String modelo;
    private String patente;
    private String combustible;
    private int kilometraje;
    private boolean alquilado;

    // Constructores
    public Vehiculo(String marca, String modelo, String patente, String combustible,
                    int kilometraje, LocalDate vencimientoAlquiler) {
        super(vencimientoAlquiler);
        this.marca = marca;
        this.modelo = modelo;
        this.patente = patente;
        this.combustible = combustible;
        this.kilometraje = kilometraje;
        this.alquilado = false;
    }

    // Métodos
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    @Override
    public boolean sePuedeAlquilarA(Cliente cliente) {
        return !alquilado;
    }

    @Override
    public void alquilarA(Cliente cliente) {
        cliente.agregarProductoAlquilado(this);
        alquilado = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;

        Vehiculo otroVehiculo = (Vehiculo) o;
        return this.getPatente().equals(otroVehiculo.getPatente());
    }

    @Override
    public String toString() {
        return modelo;
    }
}
