package tp10.e05;

import tp10.e05.condiciones.Condicion;
import java.time.LocalDate;

public class ComboEspecial extends Combo {
    // Atributos
    private Condicion politicaAceptacion;

    // Constructores
    public ComboEspecial(String id, String destino, LocalDate fechaPartida) {
        super(id, destino, fechaPartida);
        this.politicaAceptacion = null;
    }

    // Métodos
    @Override
    public void agregarElemento(ElementoDeCarga elemento) {
        if (this.politicaAceptacion != null && this.politicaAceptacion.esCumplidaPor(elemento))
            this.elementos.add(elemento);
    }

    public void setPoliticaAceptacion(Condicion politicaAceptacion) {
        if (politicaAceptacion != null)
            this.politicaAceptacion = politicaAceptacion;
    }
}
