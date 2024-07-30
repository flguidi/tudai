package tp06.e01;

import java.util.ArrayList;

public class Cliente {
    // Atributos
    private String nombre;
    private String apellido;
    private int dni;
    private ArrayList<Producto> productosAlquilados;

    // Constructores
    public Cliente(String nombre, String apellido, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.productosAlquilados = new ArrayList<>();
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void agregarProductoAlquilado(Producto producto) {
        productosAlquilados.add(producto);
    }

    public boolean poseeAlquileresVencidos() {
        for (Producto producto : productosAlquilados) {
            if (producto.tieneAlquilerVencido()) return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;

        Cliente otroCliente = (Cliente) o;
        return this.getDni() == otroCliente.getDni();
    }

    @Override
    public String toString() {
        return "Apellido y nombre: " + nombre + ", " + apellido + " - " +
                "DNI: " + dni + "\n" +
                "Productos alquilados: " + productosAlquilados;
    }
}
