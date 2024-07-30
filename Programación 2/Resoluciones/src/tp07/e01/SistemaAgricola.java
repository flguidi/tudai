package tp07.e01;

import tp07.e01.condiciones.Condicion;
import java.util.ArrayList;

public class SistemaAgricola {
    // Atributos
    private ArrayList<Cultivo> cultivos;
    private ArrayList<Agroquimico> agroquimicos;

    // Constructores
    public SistemaAgricola() {
        this.cultivos = new ArrayList<>();
        this.agroquimicos = new ArrayList<>();
    }

    // Métodos
    public void agregarCultivo(Cultivo cultivo) {
        cultivos.add(cultivo);
    }

    public void eliminarCultivo(Cultivo cultivo) {
        cultivos.remove(cultivo);
    }

    public void agregarAgroquimico(Agroquimico agroquimico) {
        if (!agroquimicos.contains(agroquimico))
            agroquimicos.add(agroquimico);
    }

    public void eliminarAgroquimico(Agroquimico agroquimico) {
        agroquimicos.remove(agroquimico);
    }

    public ArrayList<Agroquimico> obtenerAgroquimicos(Condicion condicion) {
        ArrayList<Agroquimico> lista = new ArrayList<>();
        for (int i = 0; i < agroquimicos.size(); i++) {
            Agroquimico agroquimico = agroquimicos.get(i);
            if (condicion.esCumplidaPor(agroquimico))
                lista.add(agroquimico);
        }
        return lista;
    }
}
