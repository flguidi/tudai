package tp09.e02.condiciones;

import tp09.e02.ElementoSA;
import java.time.LocalDate;

public class CondicionFecha extends Condicion {
    // Atributos
    private LocalDate fecha;

    // Constructores
    public CondicionFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(ElementoSA elemento) {
        return elemento.getFechaCreacion().isBefore(fecha);
    }
}
