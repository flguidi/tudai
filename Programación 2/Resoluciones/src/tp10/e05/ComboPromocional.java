package tp10.e05;

import java.time.LocalDate;

public class ComboPromocional extends Combo {
    // Constructores
    public ComboPromocional(String id, String destino, LocalDate fechaPartida) {
        super(id, destino, fechaPartida);
    }

    // Métodos
    @Override
    public double getCostoEnvio() {
        double total = 0;

        if (this.elementos.isEmpty())
            return total;

        for (ElementoDeCarga e : this.elementos)
                total += e.getCostoEnvio();

        return total / this.elementos.size(); // Promedio de costos que contiene el combo
    }
}
