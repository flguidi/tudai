package tp09.e02;

import tp09.e02.condiciones.Condicion;
import java.util.ArrayList;
import java.util.Comparator;

public class AccesoDirecto extends ElementoSA {
    // Atributos
    private static final double TAMANIO = 1;
    private static final String PREFIJO = "Acceso directo a ";
    private ElementoSA destino;

    // Constructores
    public AccesoDirecto(ElementoSA destino) {
        super(PREFIJO + destino.getNombre());
        this.destino = destino;
    }

    // Métodos
    @Override
    public ArrayList<ElementoSA> buscar(Condicion condicion, Comparator<ElementoSA> comparador) {
        ArrayList<ElementoSA> resultado = new ArrayList<>();
        if (condicion.esCumplidaPor(this))
            resultado.add(this);
        return resultado;
    }

    @Override
    public double getTamanio() {
        return TAMANIO;
    }
}
