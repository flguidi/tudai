package tp09.e03;

public class Candidato {
    // Atributos
    private String nombre;
    private String partido;
    private String agrupacion;

    // Constructores
    public Candidato(String nombre, String partido, String agrupacion) {
        this.nombre = nombre;
        this.partido = partido;
        this.agrupacion = agrupacion;
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getAgrupacion() {
        return agrupacion;
    }

    public void setAgrupacion(String agrupacion) {
        this.agrupacion = agrupacion;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
