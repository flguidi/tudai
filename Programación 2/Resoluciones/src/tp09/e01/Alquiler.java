package tp09.e01;

import java.time.LocalDate;

public class Alquiler {
    // Atributos
    private LocalDate fechaReserva;
    private int id;
    private double precio;

    // Constructores
    public Alquiler(LocalDate fechaReserva, int id, double precio) {
        this.fechaReserva = fechaReserva;
        this.id = id;
        this.precio = precio;
    }

    // Métodos
    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
