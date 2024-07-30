package tp02.e03;

public class Ciudad {
    // Atributos
    private String nombre;
    private int poblacion;
    private double gastosMantenimiento;
    private Impuesto[] impuestos;
    private int cantidadImpuestos;

    // Constructores
    public Ciudad(String nombre, int poblacion, int limiteImpuestos, double gastosMantenimiento) {
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.gastosMantenimiento = gastosMantenimiento;
        this.impuestos = new Impuesto[limiteImpuestos];
        this.cantidadImpuestos = 0;
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    public Impuesto getImpuesto(int numeroImpuesto) {
        if (numeroImpuesto > 0 && numeroImpuesto < this.impuestos.length)
            return this.impuestos[numeroImpuesto - 1];

        return null;
    }

    public void agregarImpuesto(Impuesto impuesto) {
        if (cantidadImpuestos >= this.impuestos.length) {
            Impuesto[] impuestosAux = new Impuesto[this.impuestos.length * 2];
            for (int i = 0; i < this.cantidadImpuestos; i++)
                impuestosAux[i] = this.impuestos[i];
            this.impuestos = impuestosAux;
        }

        this.impuestos[this.cantidadImpuestos] = impuesto;
        this.cantidadImpuestos++;
    }

    public void eliminarImpuesto() {
        if (this.cantidadImpuestos > 0) {
            this.impuestos[this.cantidadImpuestos - 1] = null;
            this.cantidadImpuestos--;

            if (this.cantidadImpuestos <= this.impuestos.length / 2) {
                Impuesto[] impuestosAux = new Impuesto[this.cantidadImpuestos];
                for (int i = 0; i < this.cantidadImpuestos; i++)
                    impuestosAux[i] = impuestos[i];
                this.impuestos = impuestosAux;
            }
        }
    }

    public double getTotalImpuestos() {
        double importeTotal = 0;
        for (int i = 0; i < this.cantidadImpuestos; i++)
            importeTotal += impuestos[i].getImporte();
        return importeTotal;
    }

    public double getGastosMantenimiento() {
        return gastosMantenimiento;
    }

    public void setGastosMantenimiento(double gastosMantenimiento) {
        this.gastosMantenimiento = gastosMantenimiento;
    }

    public boolean estaEnDeficit() {
        return gastosMantenimiento > this.getTotalImpuestos();
    }
}
