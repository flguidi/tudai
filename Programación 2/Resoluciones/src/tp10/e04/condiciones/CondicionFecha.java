package tp10.e04.condiciones;

import tp10.e04.Gasto;
import java.time.LocalDate;

public class CondicionFecha<T> extends Condicion<T> {
    // Atributos
    private LocalDate fecha;

    // Constructores
    public CondicionFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Gasto<T> gasto) {
        return gasto.getFecha().equals(this.fecha);
    }
}
