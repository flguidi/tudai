package tp09.e03.condiciones;

import tp09.e03.Voto;
import java.time.LocalDateTime;

public class CondicionFecha extends Condicion {
    // Atributos
    LocalDateTime fechaLimiteInf;
    LocalDateTime getFechaLimiteSup;

    // Constructores
    public CondicionFecha(LocalDateTime fechaLimiteInf, LocalDateTime getFechaLimiteSup) {
        this.fechaLimiteInf = fechaLimiteInf;
        this.getFechaLimiteSup = getFechaLimiteSup;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Voto voto) {
        return  voto.getFecha().isAfter(fechaLimiteInf) &&
                voto.getFecha().isBefore(getFechaLimiteSup);
    }
}
