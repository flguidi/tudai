package recuperatorio_2022_11_10;

import java.util.ArrayList;

public class Portal {
    // Atributos
    private ElementoPortal elementoRaiz;
    private ArrayList<Suscriptor> suscriptores;

    // Constructores
    public Portal(ElementoPortal elementoRaiz) {
        this.elementoRaiz = elementoRaiz;
        this.suscriptores = new ArrayList<>();
    }

    // Métodos
    public ElementoPortal getElementoRaiz() {
        return elementoRaiz;
    }

    public void setElementoRaiz(ElementoPortal elementoRaiz) {
        this.elementoRaiz = elementoRaiz;
    }

    public void repartirNoticiaASuscriptores(Noticia noticia) {
        for (int i = 0; i < suscriptores.size(); i++)
            suscriptores.get(i).recibirNoticia(noticia);
    }
}
