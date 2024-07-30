package tp05.e04;

import java.util.ArrayList;

public class Pais {
    // Atributos
    private String nombre;
    private ArrayList<Provincia> provincias;

    // Constructores
    public Pais(String nombre) {
        this.nombre = nombre;
        this.provincias = new ArrayList<>();
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Provincia getProvincia(int indiceProvincia) {
        if (indiceProvincia > 0 && indiceProvincia < this.provincias.size())
            return provincias.get(indiceProvincia);

        return null;
    }

    public void agregarProvincia(Provincia provincia) {
        if (!this.provincias.contains(provincia))
            this.provincias.add(provincia);
    }

    public void eliminarProvincia(Provincia provincia) {
        this.provincias.remove(provincia);
    }

    public ArrayList<Provincia> getProvinciasEnDeficit() {
        ArrayList<Provincia> provinciasEnDeficit = new ArrayList<>();
        for (Provincia provincia : this.provincias) {
            if (provincia.estaEnDeficit())
                provinciasEnDeficit.add(provincia);
        }
        return provinciasEnDeficit;
    }

    public String toString() {
        return "|PAIS|\n" +
                "Nombre: " + this.nombre + "\n" +
                "Cantidad de provincias: " + this.provincias.size() + "\n" +
                "Cantidad de provincias en déficit: " + getProvinciasEnDeficit().size();
    }
}
