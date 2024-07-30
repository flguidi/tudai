package tp04.e05;

import java.time.LocalDate;

public class Producto {
    // Atributos
    private String nombre;
    private String tipo;
    private LocalDate fechaEnvasado;
    private LocalDate fechaVencimiento;
    private int numeroLote;
    private String granjaOrigen;

    // Constructores
    public Producto(String nombre, String tipo, LocalDate fechaEnvasado,
                    LocalDate fechaVencimiento, int numeroLote, String granjaOrigen) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.fechaEnvasado = fechaEnvasado;
        this.fechaVencimiento = fechaVencimiento;
        this.numeroLote = numeroLote;
        this.granjaOrigen = granjaOrigen;
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFechaEnvasado() {
        return fechaEnvasado;
    }

    public void setFechaEnvasado(LocalDate fechaEnvasado) {
        this.fechaEnvasado = fechaEnvasado;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(int numeroLote) {
        this.numeroLote = numeroLote;
    }

    public String getGranjaOrigen() {
        return granjaOrigen;
    }

    public void setGranjaOrigen(String granjaOrigen) {
        this.granjaOrigen = granjaOrigen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;

        Producto otroProducto = (Producto) o;
        return this.nombre.equals(otroProducto.getNombre());
    }

    @Override
    public String toString() {
        return "|PRODUCTO| " +
                "Nombre: " + this.nombre + " - " +
                "Tipo: " + this.tipo + " - " +
                "Envasado: " + this.fechaEnvasado + " - " +
                "Vencimiento: " + this.fechaVencimiento + " - " +
                "Lote: " + this.numeroLote + " - " +
                "Granja de origen: " + this.granjaOrigen;
    }
}
