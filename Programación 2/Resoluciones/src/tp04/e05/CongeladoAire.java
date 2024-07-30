package tp04.e05;

import java.time.LocalDate;

public class CongeladoAire extends ProductoRC {
    // Atributos
    private int porcentajeN;
    private int porcentajeO2;
    private int porcentajeCO2;

    // Constructores
    public CongeladoAire(String nombre, String tipo, LocalDate fechaEnvasado, LocalDate fechaVencimiento,
                         int numeroLote, String granjaOrigen, double temperatura, String codigo,
                         int porcentajeN, int porcentajeO2, int porcentajeCO2) {
        super(nombre, tipo, fechaEnvasado, fechaVencimiento, numeroLote, granjaOrigen, temperatura, codigo);
        this.porcentajeN = porcentajeN;
        this.porcentajeO2 = porcentajeO2;
        this.porcentajeCO2 = porcentajeCO2;
    }

    // Métodos
    public int getPorcentajeN() {
        return porcentajeN;
    }

    public void setPorcentajeN(int porcentajeN) {
        this.porcentajeN = porcentajeN;
    }

    public int getPorcentajeO2() {
        return porcentajeO2;
    }

    public void setPorcentajeO2(int porcentajeO2) {
        this.porcentajeO2 = porcentajeO2;
    }

    public int getPorcentajeCO2() {
        return porcentajeCO2;
    }

    public void setPorcentajeCO2(int porcentajeCO2) {
        this.porcentajeCO2 = porcentajeCO2;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Composición del aire: " +
                "N: " + this.porcentajeN + "% - " +
                "O2: " + this.porcentajeO2 + "% - " +
                "CO2: " + this.porcentajeCO2 + "%";
    }
}
