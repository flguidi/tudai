package tp05.e02;

import java.util.ArrayList;

public class Casa {
    // Atributos
    private String nombre;
    private int capacidad;
    private ArrayList<String> cualidadesRequeridas;
    private ArrayList<Alumno> alumnos;

    // Constructores
    public Casa(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.cualidadesRequeridas = new ArrayList<>();
        this.alumnos = new ArrayList<>();
    }

    public Casa(String nombre, int capacidad, ArrayList<String> cualidadesRequeridas) {
        this(nombre, capacidad);
        this.cualidadesRequeridas = cualidadesRequeridas;
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void agregarAlumno(Alumno alumno) {
        if (!this.alumnos.contains(alumno) && aceptaA(alumno))
            this.alumnos.add(alumno);
    }

    public void eliminarAlumno(String nombre) {
        for (Alumno alumno : this.alumnos) {
            if (alumno.getNombre().equals(nombre)) {
                this.alumnos.remove(alumno);
                return;
            }
        }
    }

    public String listarAlumnos() {
        String lista = "";
        for (Alumno alumno : this.alumnos)
            lista += alumno.getNombre() + " ";
        return lista;
    }

    public boolean aceptaA(Alumno alumno) {
        if (this.alumnos.size() >= this.capacidad) return false;

        for (String cualidadRequerida : cualidadesRequeridas) {
            if (!alumno.tieneCualidad(cualidadRequerida))
                return false;
        }

        return true;
    }

    public void agregarCualidadRequerida(String cualidad) {
        if (!this.cualidadesRequeridas.contains(cualidad))
            this.cualidadesRequeridas.add(cualidad);
    }

    public void eliminarCualidadRequerida(String cualidad) {
        this.cualidadesRequeridas.remove(cualidad);
    }

    public String listarCualidadesRequeridas() {
        String lista = "";
        for (String cualidad : this.cualidadesRequeridas)
            lista += cualidad + " ";
        return lista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;

        Casa otraCasa = (Casa) o;
        return this.getNombre().equals(otraCasa.getNombre());
    }

    @Override
    public String toString() {
        return "|CASA|\n" +
                "Nombre: " + this.nombre + "\n" +
                "Cupo máximo: " + this.capacidad + " estudiantes\n" +
                "Cualidades requeridas: " + this.listarCualidadesRequeridas() + "\n" +
                "Alumnos: " + listarAlumnos();
    }
}
