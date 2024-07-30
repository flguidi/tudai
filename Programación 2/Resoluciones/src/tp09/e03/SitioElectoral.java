package tp09.e03;

import tp09.e03.condiciones.Condicion;
import java.util.ArrayList;

public class SitioElectoral extends ElementoElectoral {
    // Atributos
    private ArrayList<Integer> padron;
    private ArrayList<ElementoElectoral> elementosElectorales;

    // Constructores
    public SitioElectoral() {
        this.padron = new ArrayList<>();
        this.elementosElectorales = new ArrayList<>();
    }

    // Métodos
    public void agregarDniPadron(int dni) {
        if (!padron.contains(dni))
            padron.add(dni);
    }

    public void eliminarDniPadron(int dni) {
        padron.remove(dni);
    }

    public void registrarVoto(Voto voto) {
        if (existeEnPadron(voto.getDniVotante()) && !elementosElectorales.contains(voto))
            elementosElectorales.add(voto);
    }

    public boolean existeEnPadron(int dni) {
        return padron.contains(dni);
    }

    public void agregarSitioElectoral(SitioElectoral sitio) {
        elementosElectorales.add(sitio);
    }

    public void eliminarSitioElectoral(SitioElectoral sitio) {
        elementosElectorales.remove(sitio);
    }

    @Override
    public int contarVotos() {
        int total = 0;
        for (int i = 0; i < elementosElectorales.size(); i++) {
            ElementoElectoral actual = elementosElectorales.get(i);
            total += actual.contarVotos();
        }
        return total;
    }

    public double calcularPorcentaje(Condicion condicion) {
        int votosQueCumplen = this.filtrar(condicion);
        int totalVotos = this.contarVotos();
        return (double) votosQueCumplen / totalVotos * 100;
    }

    public int filtrar(Condicion condicion) {
        int total = 0;
        for (int i = 0; i < elementosElectorales.size(); i++) {
            ElementoElectoral actual = elementosElectorales.get(i);
            total += actual.filtrar(condicion);
        }
        return total;
    }
}
