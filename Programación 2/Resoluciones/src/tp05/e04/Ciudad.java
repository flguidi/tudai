package tp05.e04;

import java.util.ArrayList;

public class Ciudad {
    // Atributos
    private String nombre;
    private int poblacion;
    private double gastosMantenimiento;
    private ArrayList<Contribuyente> contribuyentes;

    // Constructores
    public Ciudad(String nombre, int poblacion, double gastosMantenimiento) {
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.gastosMantenimiento = gastosMantenimiento;
        this.contribuyentes = new ArrayList<>();
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

    public double getGastosMantenimiento() {
        return gastosMantenimiento;
    }

    public void setGastosMantenimiento(double gastosMantenimiento) {
        this.gastosMantenimiento = gastosMantenimiento;
    }

    public void agregarContribuyente(Contribuyente contribuyente) {
        if (!contribuyentes.contains(contribuyente)) {
            this.contribuyentes.add(contribuyente);
        }
    }

    public void eliminarContribuyente(Contribuyente contribuyente) {
        this.contribuyentes.remove(contribuyente);
    }

    public boolean estaEnDeficit() {
        return gastosMantenimiento > getTotalImpuestos();
    }

    public double getTotalImpuestos() {
        double importeTotal = 0;
        for (Contribuyente contribuyente : this.contribuyentes)
            importeTotal += contribuyente.getImpuesto();
        return importeTotal;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;

        Ciudad otraCiudad = (Ciudad) o;
        return (this.nombre.equals(otraCiudad.getNombre()));
    }

    @Override
    public String toString() {
        return "|CIUDAD|\n" +
                "Nombre: " + this.nombre + "\n" +
                "Cantidad de habitantes: " + this.poblacion + "\n" +
                "Cantidad de contribuyentes: " + this.contribuyentes.size() + "\n" +
                "Total recaudado: " + this.getTotalImpuestos() + "\n" +
                "Gastos en mantenimiento: " + this.gastosMantenimiento + "\n" +
                "Está en déficit: " + estaEnDeficit();
    }
}
