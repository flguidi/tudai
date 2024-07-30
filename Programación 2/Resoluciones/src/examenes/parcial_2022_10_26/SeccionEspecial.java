package parcial_2022_10_26;

import java.util.ArrayList;
import java.util.Collections;

public class SeccionEspecial extends Seccion {
    // Atributos
    private String categoriaFija;
    private int cantidad;

    // Constructores
    public SeccionEspecial(int posicionCategoria, String categoriaFija, int cantidad) {
        super(posicionCategoria);
        this.categoriaFija = categoriaFija;
        this.cantidad = cantidad;
    }

    // Métodos
    @Override
    public String getCategoria() {
        return categoriaFija;
    }

    @Override
    public ArrayList<String> obtenerPalabrasClaves() {
        ArrayList<String> aux = super.obtenerPalabrasClaves();
        Collections.sort(aux);
        ArrayList<String> resultado = new ArrayList<>();
        for (int i = 0; i < aux.size() && i < cantidad; i++) {
            resultado.add(aux.get(i));
        }
        return resultado;
    }
}
