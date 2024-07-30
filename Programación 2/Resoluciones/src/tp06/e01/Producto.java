package tp06.e01;

import java.time.LocalDate;

public abstract class Producto {
    // Atributos
    private LocalDate vencimientoAlquiler;

    // Constructores
    public Producto(LocalDate vencimientoAlquiler) {
        this.vencimientoAlquiler = vencimientoAlquiler;
    }

    // Métodos
    public boolean tieneAlquilerVencido() {
        LocalDate hoy = LocalDate.now();
        return hoy.isAfter(vencimientoAlquiler);
    }

    public LocalDate getVencimientoAlquiler() {
        return vencimientoAlquiler;
    }

    public void setVencimientoAlquiler(LocalDate vencimientoAlquiler) {
        this.vencimientoAlquiler = vencimientoAlquiler;
    }

    public abstract boolean sePuedeAlquilarA(Cliente cliente);

    public abstract void alquilarA(Cliente cliente);
}
