package tp07.e03;

import java.util.ArrayList;

public class Planta {
    // Atributos
    private String nombreCientifico;
    private ArrayList<String> nombresVulgares;
    private String clasificacionSuperior;
    private String familia;
    private String clase;
    private boolean deInterior;
    private int solRequerido;
    private int aguaRequerida;

    // Constructores
    public Planta(String nombreCientifico, String clasificacionSuperior, String familia, String clase,
                  boolean deInterior, int solRequerido, int aguaRequerida) {
        this.nombreCientifico = nombreCientifico;
        this.nombresVulgares = new ArrayList<>();
        this.clasificacionSuperior = clasificacionSuperior;
        this.familia = familia;
        this.clase = clase;
        this.deInterior = deInterior;
        this.solRequerido = solRequerido;
        this.aguaRequerida = aguaRequerida;
    }

    // Métodos
    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public void agregarNombreVulgar(String nombre) {
        if (!nombresVulgares.contains(nombre))
            nombresVulgares.add(nombre);
    }

    public void eliminarNombreVulgar(String nombre) {
        nombresVulgares.remove(nombre);
    }

    public boolean tieneNombreVulgar(String nombre) {
        return nombresVulgares.contains(nombre);
    }

    public String getClasificacionSuperior() {
        return clasificacionSuperior;
    }

    public void setClasificacionSuperior(String clasificacionSuperior) {
        this.clasificacionSuperior = clasificacionSuperior;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public boolean isDeInterior() {
        return deInterior;
    }

    public void setDeInterior(boolean deInterior) {
        this.deInterior = deInterior;
    }

    public int getSolRequerido() {
        return solRequerido;
    }

    public void setSolRequerido(int solRequerido) {
        this.solRequerido = solRequerido;
    }

    public int getAguaRequerida() {
        return aguaRequerida;
    }

    public void setAguaRequerida(int aguaRequerida) {
        this.aguaRequerida = aguaRequerida;
    }

    public String obtenerInformacion() {
        return "INFORMACIÓN DE PLANTA\n" +
                "Nombre científico: " + nombreCientifico + "\n" +
                "Nombres vulgares: " + nombresVulgares + "\n" +
                "Clasificación superior: " + clasificacionSuperior + "\n" +
                "Familia: " + familia + "\n" +
                "Clase: " + clase + "\n" +
                "Es de interior: " + deInterior + "\n" +
                "Requerimiento de sol: " + solRequerido + "\n" +
                "Requerimiento de agua: " + aguaRequerida + "\n";
    }

    @Override
    public String toString() {
        return nombreCientifico;
    }
}
