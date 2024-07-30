package tp09.e08;

import tp09.e08.condiciones.Condicion;
import java.util.ArrayList;
import java.util.Comparator;

public class GrupoSponsoreado extends Grupo {
    // Atributos
    private Video videoSponsoreado;

    // Constructores
    public GrupoSponsoreado(String titulo, int demoraCarga, Video videoSponsoreado) {
        super(titulo, demoraCarga);
        this.videoSponsoreado = videoSponsoreado;
    }

    // Métodos
    public Video getVideoSponsoreado() {
        return videoSponsoreado;
    }

    public void setVideoSponsoreado(Video videoSponsoreado) {
        this.videoSponsoreado = videoSponsoreado;
    }

    @Override
    public ArrayList<Video> buscar(Condicion cond, Comparator<Video> comp) {
        ArrayList<Video> busqueda = new ArrayList<>();
        busqueda.add(this.videoSponsoreado);
        busqueda.addAll(super.buscar(cond, comp));
        return busqueda;
    }
}
