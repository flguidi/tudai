package tp09.e04;

import tp09.e04.condiciones.*;
import java.util.ArrayList;

public class Categoria extends ElementoPortal {
    // Atributos
    private String descripcion;
    private String urlImagen;
    private ArrayList<ElementoPortal> elementosPortal;

    // Constructores
    public Categoria(String descripcion, String urlImagen) {
        this.elementosPortal = new ArrayList<>();
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
    }

    // Métodos
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public void agregarElemento(ElementoPortal elemento) {
        if (!elementosPortal.contains(elemento))
            elementosPortal.add(elemento);
    }

    public void eliminarElemento(ElementoPortal elemento) {
        elementosPortal.remove(elemento);
    }

    @Override
    public int contarNoticias() {
        int total = 0;
        for (ElementoPortal elemento : elementosPortal)
            total += elemento.contarNoticias();
        return total;
    }

    @Override
    public ArrayList<Noticia> buscar(Condicion condicion) {
        ArrayList<Noticia> busqueda = new ArrayList<>();
        for (ElementoPortal elemento : elementosPortal)
            busqueda.addAll(elemento.buscar(condicion));
        return busqueda;
    }

    @Override
    public ArrayList<ElementoPortal> copiar(Condicion condicion) {
        ArrayList<ElementoPortal> copia = new ArrayList<>();
        for (ElementoPortal elemento : elementosPortal)
            copia.addAll(elemento.copiar(condicion));
        return copia;
    }

    @Override
    public ElementoPortal copiar() {
        return new Categoria(descripcion, urlImagen);
    }

    public String imprimirLista() {
        String str = "";
        if (this.elementosPortal.isEmpty())
            str += "\n";
        else {
            for (ElementoPortal elemento : elementosPortal)
                str += this.descripcion + "/" + elemento.imprimirLista();
        }
        return str;
    }
}
