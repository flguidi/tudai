package tp09.e01;

import java.util.ArrayList;

public class Socio implements Comparable<Socio> {
    // Atributos
    private String nombre;
    private String apellido;
    private int edad;
    private boolean ultimaCuotaPaga;
    private ArrayList<Alquiler> alquileres;

    // Constructores
    public Socio(String nombre, String apellido, int edad, boolean ultimaCuotaPaga) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.ultimaCuotaPaga = ultimaCuotaPaga;
        this.alquileres = new ArrayList<>();
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isUltimaCuotaPaga() {
        return ultimaCuotaPaga;
    }

    public void setUltimaCuotaPaga(boolean ultimaCuotaPaga) {
        this.ultimaCuotaPaga = ultimaCuotaPaga;
    }

    public void alquilarCancha(Alquiler alquiler) {
        if (!alquileres.contains(alquiler))
            alquileres.add(alquiler);
    }

    public void eliminarAlquiler(Alquiler alquiler) {
        alquileres.remove(alquiler);
    }

    public int cantAlquileresCancha(int idCancha) {
        int contador = 0;
        for (int i = 0; i < alquileres.size(); i++) {
            if (alquileres.get(i).getId() == idCancha)
                contador++;
        }
        return contador;
    }

    public boolean pagoMasQue(double precio) {
        for (int i = 0; i < alquileres.size(); i++) {
            if (alquileres.get(i).getPrecio() > precio)
                return true;
        }
        return false;
    }

    @Override
    public int compareTo(Socio otro) {
        return this.apellido.compareTo(otro.getApellido());
    }

    @Override
    public String toString() {
        return  nombre + " " + apellido + " (Edad: " + edad + " - " +
                "Última cuota paga: " + ultimaCuotaPaga + ")";
    }
}
