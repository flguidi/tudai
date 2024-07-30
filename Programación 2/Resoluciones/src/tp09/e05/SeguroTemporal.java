package tp09.e05;

import tp09.e05.condiciones.Condicion;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class SeguroTemporal extends SeguroSimple {
    // Atributos
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    // Constructores
    public SeguroTemporal(int dniDuenio, int numeroPoliza, String descripcion, double montoAsegurado,
                          LocalDate fechaInicio, LocalDate fechaFin) {
        super(dniDuenio, numeroPoliza, descripcion, montoAsegurado);
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    // Métodos
    @Override
    public double getMontoAsegurado() {
        LocalDate hoy = LocalDate.now();
        if (hoy.isAfter(fechaInicio) && hoy.isBefore(fechaFin))
            return super.getMontoAsegurado();
        else
            return 0;
    }

    @Override
    public ArrayList<SeguroSimple> buscar(Condicion cond, Comparator<Seguro> comp) {
        ArrayList<SeguroSimple> busqueda = new ArrayList<>();
        LocalDate hoy = LocalDate.now();
        if (cond.esCumplidaPor(this) && hoy.isAfter(fechaInicio) && hoy.isBefore(fechaFin))
            busqueda.add(this);
        return busqueda;
    }
}
