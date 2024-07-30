package tp10.e03.criterios_aceptacion;

import tp10.e03.Pedido;
import java.time.LocalDate;

public class CriterioFecha extends CriterioAceptacion {
    // Atributos
    private LocalDate fechaMaxima;

    // Constructores
    public CriterioFecha(LocalDate fechaMaxima) {
        this.fechaMaxima = fechaMaxima;
    }

    // Métodos
    @Override
    public boolean acepta(Pedido pedido) {
        return pedido.getFechaLimiteEntrega().isBefore(fechaMaxima);
    }
}
