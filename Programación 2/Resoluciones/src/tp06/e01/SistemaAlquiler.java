package tp06.e01;

import java.util.ArrayList;

public class SistemaAlquiler {
    // Atributos
    private ArrayList<Producto> productos;
    private ArrayList<Cliente> clientes;

    // Constructores
    public SistemaAlquiler() {
        this.productos = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    // Métodos
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
    }

    public void agregarCliente(Cliente cliente) {
        if (!clientes.contains(cliente))
            clientes.add(cliente);
    }

    public void eliminarCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    public String getClientesAlquileresVencidos() {
        String lista = "";
        for (Cliente cliente : clientes) {
            if (cliente.poseeAlquileresVencidos())
                lista += cliente.getNombre() + " " + cliente.getApellido() + " (DNI: " + cliente.getDni() + ")\n";
        }
        return lista;
    }

    public void alquilar(Producto producto, Cliente cliente) {
        if (producto.sePuedeAlquilarA(cliente))
            producto.alquilarA(cliente);
    }
}
