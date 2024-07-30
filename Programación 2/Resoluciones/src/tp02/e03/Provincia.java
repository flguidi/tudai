package tp02.e03;

public class Provincia {
    // Atributos
    private String nombre;
    private int poblacion;
    private Ciudad[] ciudades;
    private int cantidadCiudades;

    // Constructores
    public Provincia(String nombre, int limiteCiudades) {
        this.nombre = nombre;
        this.ciudades = new Ciudad[limiteCiudades];
        this.poblacion = this.getPoblacion();
        this.cantidadCiudades = 0;
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPoblacion() {
        int poblacionTotal = 0;
        for (int i = 0; i < cantidadCiudades; i++)
            poblacionTotal += ciudades[i].getPoblacion();
        return poblacionTotal;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    public Ciudad getCiudad(int numeroCiudad) {
        if (numeroCiudad > 0 && numeroCiudad < this.ciudades.length)
            return ciudades[numeroCiudad - 1];

        return null;
    }

    public void agregarCiudad(Ciudad ciudad) {
        if (cantidadCiudades >= this.ciudades.length) {
            Ciudad[] ciudadesAux = new Ciudad[this.ciudades.length * 2];
            for (int i = 0; i < this.cantidadCiudades; i++)
                ciudadesAux[i] = this.ciudades[i];
            this.ciudades = ciudadesAux;
        }

        this.ciudades[this.cantidadCiudades] = ciudad;
        this.cantidadCiudades++;
    }

    public void eliminarCiudad() {
        if (this.cantidadCiudades > 0) {
            this.ciudades[this.cantidadCiudades - 1] = null;
            this.cantidadCiudades--;

            if (this.cantidadCiudades <= this.ciudades.length / 2) {
                Ciudad[] ciudadesAux = new Ciudad[this.cantidadCiudades];
                for (int i = 0; i < this.cantidadCiudades; i++)
                    ciudadesAux[i] = ciudades[i];
                this.ciudades = ciudadesAux;
            }
        }
    }

    public int getCantidadCiudades() {
        return cantidadCiudades;
    }

    public int getCantCiudadesEnDeficit() {
        int cantEnDeficit = 0;

        for (int i = 0; i < this.cantidadCiudades; i++) {
            if (ciudades[i].estaEnDeficit()) {
                cantEnDeficit++;
            }
        }

        return cantEnDeficit;
    }

    public String getNombreCiudadesEnDeficit() {
        String ciudadesEnDeficit = "";

        for (int i = 0; i < this.cantidadCiudades; i++) {
            if (ciudades[i].estaEnDeficit()) {
                ciudadesEnDeficit += ciudades[i].getNombre() + " ";
            }
        }

        return ciudadesEnDeficit;
    }
}
