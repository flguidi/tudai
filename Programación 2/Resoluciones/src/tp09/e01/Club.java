package tp09.e01;

import tp09.e01.condiciones.Condicion;
import java.util.ArrayList;
import java.util.Comparator;

public class Club {
    // Atributos
    private ArrayList<Socio> socios;

    // Constructores
    public Club() {
        this.socios = new ArrayList<>();
    }

    // Métodos
    public void agregarSocio(Socio socio) {
        if (!socios.contains(socio))
            socios.add(socio);
    }

    public void eliminarSocio(Socio socio) {
        socios.remove(socio);
    }

    public ArrayList<Socio> buscar(Condicion condicion, Comparator<Socio> comparador) {
        ArrayList<Socio> resultado = new ArrayList<>();
        for (int i = 0; i < socios.size(); i++) {
            Socio socio = socios.get(i);
            if (condicion.esCumplidaPor(socio))
                resultado.add(socio);
        }
        resultado.sort(comparador);
        return resultado;
    }

    public void imprimirLista(ArrayList<Socio> lista) {
        String str = "[";
        for (int i = 0; i < lista.size(); i++) {
            str += lista.get(i);
            if (i < lista.size() - 1)
                str += ", \n";
        }
        str += "]";
        System.out.println(str);
    }

    @Override
    public String toString() {
        String str = "[";
        for (int i = 0; i < socios.size(); i++) {
            str += socios.get(i);
            if (i < socios.size() - 1)
                str += ", \n";
        }
        str += "]";
        return str;
    }
}
