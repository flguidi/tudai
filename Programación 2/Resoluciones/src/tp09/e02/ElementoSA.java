package tp09.e02;

import tp09.e02.condiciones.Condicion;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public abstract class ElementoSA implements Comparable<ElementoSA> {
    // Atributos
    private String nombre;
    private LocalDate fechaCreacion;
    private ElementoSA contenedor;

    // Constructores
    public ElementoSA(String nombre) {
        this.nombre = nombre;
        this.fechaCreacion = LocalDate.now();
        this.contenedor = null;
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public ElementoSA getContenedor() {
        return contenedor;
    }

    public void setContenedor(ElementoSA contenedor) {
        this.contenedor = contenedor;
    }

    public int getCantidadElementos() {
        return 1; // El elemento se cuenta a sí mismo
    }

    public abstract double getTamanio();

    public abstract ArrayList<ElementoSA> buscar(Condicion condicion, Comparator<ElementoSA> comparador);

    public String getRuta() {
        String ruta = "";
        if (this.getContenedor() != null)
            ruta = this.getContenedor().getRuta() + "\\" + this;
        return ruta;
    }

    @Override
    public boolean equals(Object o) {
        try {
            ElementoSA otro = (ElementoSA) o;
            return this.getNombre().equals(otro.getNombre());
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public int compareTo(ElementoSA otroElemento) {
        return this.nombre.compareTo(otroElemento.getNombre());
    }

    public String getInformacion() {
        return "Nombre: " + nombre + "\n" +
                "Contenedor: " + contenedor + "\n" +
                "Cantidad de elementos: " + getCantidadElementos() + "\n" +
                "Tamaño total: " + getTamanio() + " KB\n" +
                "Ruta: " + getRuta();
    }

    @Override
    public String toString() {
        return nombre;
    }
}
