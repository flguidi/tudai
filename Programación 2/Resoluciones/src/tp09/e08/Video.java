package tp09.e08;

import tp09.e08.condiciones.Condicion;
import java.util.ArrayList;
import java.util.Comparator;

public class Video extends ElementoReproducible {
    // Atributos
    private String titulo;
    private Usuario usuario;
    private int duracion;
    private int cantVisualizaciones;
    private int cantMeGusta;
    private int cantNoMeGusta;
    private int anioPublicacion;
    private ArrayList<String> palabrasClave;

    // Constructores
    public Video(String titulo, Usuario usuario, int duracion, int cantVisualizaciones,
                 int cantMeGusta, int cantNoMeGusta, int anioPublicacion) {
        super(titulo);
        this.usuario = usuario;
        this.duracion = duracion;
        this.cantVisualizaciones = cantVisualizaciones;
        this.cantMeGusta = cantMeGusta;
        this.cantNoMeGusta = cantNoMeGusta;
        this.anioPublicacion = anioPublicacion;
        this.palabrasClave = new ArrayList<>();
    }

    // Métodos
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getCantVisualizaciones() {
        return cantVisualizaciones;
    }

    public void setCantVisualizaciones(int cantVisualizaciones) {
        this.cantVisualizaciones = cantVisualizaciones;
    }

    public int getCantMeGusta() {
        return cantMeGusta;
    }

    public void setCantMeGusta(int cantMeGusta) {
        this.cantMeGusta = cantMeGusta;
    }

    public int getCantNoMeGusta() {
        return cantNoMeGusta;
    }

    public void setCantNoMeGusta(int cantNoMeGusta) {
        this.cantNoMeGusta = cantNoMeGusta;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public void agregarPalabraClave(String palabra) {
        if (!this.palabrasClave.contains(palabra))
            this.palabrasClave.add(palabra);
    }

    public void eliminarPalabraClave(String palabra) {
        this.palabrasClave.remove(palabra);
    }

    public boolean contienePalabra(String palabra) {
        return this.palabrasClave.contains(palabra);
    }

    @Override
    public ArrayList<String> getPalabrasClave() {
        return new ArrayList<>(this.palabrasClave);
    }

    @Override
    public int getCantidadVideos() {
        return 1;
    }

    @Override
    public ArrayList<Video> buscar(Condicion cond, Comparator<Video> comp) {
        ArrayList<Video> busqueda = new ArrayList<>();
        if (cond.esCumplidaPor(this))
            busqueda.add(this);
        return busqueda;
    }
}
