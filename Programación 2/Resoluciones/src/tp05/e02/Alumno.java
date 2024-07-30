package tp05.e02;

import java.util.ArrayList;

public class Alumno {
    // Atributos
    private String nombre;
    private ArrayList<String> cualidades;
    private ArrayList<Alumno> familiares;
    private Casa casa;

    // Constructores
    public Alumno(String nombre) {
        this.nombre = nombre;
        this.cualidades = new ArrayList<>();
        this.familiares = new ArrayList<>();
    }

    public Alumno(String nombre, ArrayList<String> cualidades) {
        this(nombre);
        this.cualidades = cualidades;
    }

    public Alumno(String nombre, ArrayList<String> cualidades, ArrayList<Alumno> familiares) {
        this(nombre, cualidades);
        this.familiares = familiares;
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public void agregarCualidad(String cualidad) {
        if (!cualidades.contains(cualidad))
            this.cualidades.add(cualidad);
    }

    public void eliminarCualidad(String cualidad) {
        this.cualidades.remove(cualidad);
    }

    public String getCualidad(int indice) {
        if (indice >= 0 && indice < cualidades.size())
            return cualidades.get(indice);

        return null;
    }

    public boolean tieneCualidad(String cualidadRequerida) {
        return this.cualidades.contains(cualidadRequerida);
    }

    public String listarCualidades() {
        String lista = "";
        for (String cualidad : this.cualidades)
            lista += cualidad + " ";
        return lista;
    }

    public void agregarFamiliar(Alumno familiar) {
        if (!familiares.contains(familiar))
            this.familiares.add(familiar);
    }

    public void eliminarFamiliar(String nombre) {
        for (Alumno familiar : familiares) {
            if (familiar.getNombre().equals(nombre)) {
                this.familiares.remove(familiar);
                return;
            }
        }
    }

    public boolean tieneFamiliarEn(Casa casa) {
        for (Alumno familiar : this.familiares) {
            if (familiar.getCasa().equals(casa))
                return true;
        }
        return false;
    }

    public String listarFamiliares() {
        String lista = "";
        for (Alumno familiar : this.familiares)
            lista += familiar.getNombre() + " ";
        return lista;
    }

    @Override
    public String toString() {
        return "|ALUMNO|\n" +
                "Nombre: " + this.nombre + "\n" +
                "Cualidades: " + listarCualidades() + "\n" +
                "Familiares: " + listarFamiliares();
    }
}
