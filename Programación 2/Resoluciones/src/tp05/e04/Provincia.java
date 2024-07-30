package tp05.e04;

import java.util.ArrayList;

public class Provincia {
    // Atributos
    private String nombre;
    private int poblacion;
    private ArrayList<Ciudad> ciudades;

    // Constructores
    public Provincia(String nombre) {
        this.nombre = nombre;
        this.ciudades = new ArrayList<>();
        this.poblacion = this.getPoblacion();
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
        for (Ciudad ciudad : this.ciudades)
            poblacionTotal += ciudad.getPoblacion();
        return poblacionTotal;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    public Ciudad getCiudad(int indiceCiudad) {
        if (indiceCiudad > 0 && indiceCiudad < this.ciudades.size())
            return ciudades.get(indiceCiudad);

        return null;
    }

    public void agregarCiudad(Ciudad ciudad) {
        if (!this.ciudades.contains(ciudad))
            this.ciudades.add(ciudad);
    }

    public void eliminarCiudad(Ciudad ciudad) {
        this.ciudades.remove(ciudad);
    }

    public ArrayList<Ciudad> getCiudadesEnDeficit() {
        ArrayList<Ciudad> ciudadesEnDeficit = new ArrayList<>();
        for (Ciudad ciudad : this.ciudades) {
            if (ciudad.estaEnDeficit())
                ciudadesEnDeficit.add(ciudad);
        }
        return ciudadesEnDeficit;
    }

    public String getNombreCiudadesEnDeficit() {
        ArrayList<Ciudad> ciudadesEnDeficit = getCiudadesEnDeficit();
        String lista = "";
        for (Ciudad ciudad : ciudadesEnDeficit)
            lista += ciudad.getNombre() + " ";
        return lista;
    }

    public boolean estaEnDeficit() {
        return (getCiudadesEnDeficit().size()) > (this.ciudades.size() / 2);
    }

    @Override
    public boolean equals (Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;

        Provincia otraProvincia = (Provincia) o;
        return (this.nombre.equals(otraProvincia.getNombre()));
    }

    @Override
    public String toString() {
        return "|PROVINCIA|\n" +
                "Nombre: " + this.nombre + "\n" +
                "Cantidad de ciudades: " + this.ciudades.size() + "\n" +
                "Cantidad de ciudades en déficit: " + getCiudadesEnDeficit().size() + "\n" +
                "Está en déficit: " + estaEnDeficit();
    }
}
