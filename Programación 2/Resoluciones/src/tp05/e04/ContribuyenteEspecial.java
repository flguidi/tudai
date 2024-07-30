package tp05.e04;

public class ContribuyenteEspecial extends Contribuyente {
    // Atributos
    private double facturacion;
    private double porcentajeFacturacion;
    private double porcentajeMontoFijo;

    // Constructores
    public ContribuyenteEspecial(String nombre, String idTributaria, double montoFijo, double porcentajeMontoFijo,
                                 double facturacion, double porcentajeFacturacion) {
        super(nombre, idTributaria, montoFijo);
        this.porcentajeMontoFijo = porcentajeMontoFijo;
        this.facturacion = facturacion;
        this.porcentajeFacturacion = porcentajeFacturacion;
    }

    // Métodos
    public double getFacturacion() {
        return facturacion;
    }

    @Override
    public double getImpuesto() {
        return super.getImpuesto() * porcentajeMontoFijo + facturacion * porcentajeFacturacion;
    }
}
