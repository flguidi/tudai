package tp09.e05;

import tp09.e05.condiciones.Condicion;
import java.util.ArrayList;
import java.util.Comparator;

public class SeguroIntegrador extends Seguro {
    // Atributos
    private ArrayList<Seguro> seguros;

    // Constructores
    public SeguroIntegrador(int dniDuenio) {
        super(dniDuenio);
        this.seguros = new ArrayList<>();
    }

    // Métodos
    public void agregarSeguro(Seguro seguro) {
        if (!this.seguros.contains(seguro) && seguro.getDniDuenio() == this.getDniDuenio())
            this.seguros.add(seguro);
    }

    public void eliminarSeguro(Seguro seguro) {
        this.seguros.remove(seguro);
    }

    @Override
    public int getNumeroPoliza() {
        int polizaResultante = 0;
        for (Seguro seguro : this.seguros) {
            int polizaActual = seguro.getNumeroPoliza();
            if (polizaActual > polizaResultante)
                polizaResultante = polizaActual;
        }
        return polizaResultante;
    }

    @Override
    public double getMontoAsegurado() {
        double montoTotal = 0;
        for (Seguro seguro : this.seguros)
            montoTotal += seguro.getMontoAsegurado();
        return montoTotal;
    }

    @Override
    public double calcularCosto() {
        double costoTotal = 0;
        for (Seguro seguro : this.seguros)
            costoTotal += seguro.calcularCosto();
        return costoTotal;
    }

    @Override
    public ArrayList<SeguroSimple> buscar(Condicion cond, Comparator<Seguro> comp) {
        ArrayList<SeguroSimple> busqueda = new ArrayList<>();
        for (Seguro seguro : this.seguros)
            busqueda.addAll(seguro.buscar(cond, comp)); // Se busca según una condición
        busqueda.sort(comp); // Se ordena el resultado
        return busqueda;
    }
}
