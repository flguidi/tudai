package tp09.e08;

import tp09.e08.condiciones.Condicion;
import java.util.ArrayList;
import java.util.Comparator;

public class Grupo extends ElementoReproducible {
    // Atributos
    private int demoraCarga;
    private ArrayList<ElementoReproducible> elementos;

    // Constructores
    public Grupo(String titulo, int demoraCarga) {
        super(titulo);
        this.demoraCarga = demoraCarga;
        this.elementos = new ArrayList<>();
    }

    // Métodos
    public int getDemoraCarga() {
        return demoraCarga;
    }

    public void setDemoraCarga(int demoraCarga) {
        this.demoraCarga = demoraCarga;
    }

    public void agregarElemento(ElementoReproducible elemento) {
        this.elementos.add(elemento);
    }

    public void eliminarElemento(ElementoReproducible elemento) {
        this.elementos.remove(elemento);
    }

    @Override
    public int getCantidadVideos() {
        int cantidad = 0;
        for (ElementoReproducible e : this.elementos)
            cantidad += e.getCantidadVideos();
        return cantidad;
    }

    @Override
    public int getDuracion() {
        int duracion = this.demoraCarga;
        for (ElementoReproducible e : this.elementos)
            duracion += e.getDuracion();
        return duracion;
    }

    @Override
    public ArrayList<String> getPalabrasClave() {
        ArrayList<String> palabras = new ArrayList<>();
        for (ElementoReproducible e : this.elementos) {
            ArrayList<String> listaParcial = e.getPalabrasClave();
            for (String p : listaParcial) {
                if (!palabras.contains(p))
                    palabras.add(p);
            }
        }
        return palabras;
    }

    @Override
    public ArrayList<Video> buscar(Condicion cond, Comparator<Video> comp) {
        ArrayList<Video> busqueda = new ArrayList<>();
        for (ElementoReproducible e : this.elementos)
            busqueda.addAll(e.buscar(cond, comp));
        busqueda.sort(comp);
        return busqueda;
    }
}
