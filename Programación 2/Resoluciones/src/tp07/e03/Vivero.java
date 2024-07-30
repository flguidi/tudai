package tp07.e03;

import tp07.e03.condiciones.Condicion;
import java.util.ArrayList;

public class Vivero {
    // Atributos
    private ArrayList<Planta> plantas;

    // Constructores
    public Vivero() {
        this.plantas = new ArrayList<>();
    }

    // Métodos
    public void agregarPlanta(Planta planta) {
        plantas.add(planta);
    }

    public void eliminarPlanta(Planta planta) {
        plantas.remove(planta);
    }

    public ArrayList<Planta> buscarPlantas(Condicion condicion) {
        ArrayList<Planta> lista = new ArrayList<>();
        for (int i = 0; i < plantas.size(); i++) {
            Planta planta = plantas.get(i);
            if (condicion.esCumplidaPor(planta))
                lista.add(planta);
        }
        return lista;
    }
}
