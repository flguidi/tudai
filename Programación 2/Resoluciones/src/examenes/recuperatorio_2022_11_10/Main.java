package recuperatorio_2022_11_10;

import recuperatorio_2022_11_10.condiciones.*;

public class Main {
    public static void main(String[] args) {
        // Se instancian noticias y se agregan palabras claves
        Noticia n1 = new Noticia("Categoría 1", "Título 1", "Autor 1", "Contenido 1");
        Noticia n2 = new Noticia("Categoría 2", "Título 2", "Autor 2", "Contenido 2");
        Noticia n3 = new Noticia("Categoría 3", "Título 3", "Autor 3", "Contenido 3");
        Noticia n4 = new Noticia("Categoría 4", "Título 3", "Autor 3", "Contenido 3");
        n1.agregarPalabraClave("Robo");
        n1.agregarPalabraClave("Crimen");
        n2.agregarPalabraClave("Argentina");
        n2.agregarPalabraClave("Fútbol");
        n3.agregarPalabraClave("Argentina");
        n3.agregarPalabraClave("Elecciones");

        // Se instancia una sección y se agregan las noticias
        Seccion seccion = new Seccion("Resumen");
        seccion.agregarElemento(n1);
        seccion.agregarElemento(n2);
        seccion.agregarElemento(n3);

        System.out.println("Palabras claves:");
        System.out.println("Noticia 1: " + n1.obtenerPalabrasClaves());
        System.out.println("Noticia 2: " + n2.obtenerPalabrasClaves());
        System.out.println("Noticia 3: " + n3.obtenerPalabrasClaves());
        System.out.println("Sección: " + seccion.obtenerPalabrasClaves());

        // Copias restringidas
        System.out.println("\nCopias restringidas:");
        Seccion copiaSeccion = (Seccion) seccion.copiar(new CondicionPalabraClave("Argentina"));
        System.out.println(copiaSeccion);

    }
}
