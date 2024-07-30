package tp09.e04;

import tp09.e04.condiciones.*;

public class Main {
    public static void main(String[] args) {
        // Se instancian secciones y noticias
        Categoria general = new Categoria("Generales", "linkImagen1");
        Categoria espectaculos = new Categoria("Espectáculos", "linkImagen2");
        Categoria deportes = new Categoria("Deportes", "linkImagen3");

        Noticia n1 = new Noticia("Título 1", "Introducción 1", "Texto 1", "Autor 1", "Link1");
        Noticia n2 = new Noticia("Título 2", "Introducción 2", "Texto 2", "Autor 2", "Link2");
        Noticia n3 = new Noticia("Título 3", "Introducción 3", "Texto 3", "Autor 3", "Link3");

        espectaculos.agregarElemento(n1);
        espectaculos.agregarElemento(n2);
        deportes.agregarElemento(n3);
        general.agregarElemento(espectaculos);
        general.agregarElemento(deportes);

        // Cantidad de noticias
        System.out.println("CANTIDAD DE NOTICIAS");
        System.out.println("Cantidad en la categoría Generales: " + general.contarNoticias());
        System.out.println("Cantidad en la categoría Espectáculos: " + espectaculos.contarNoticias());
        System.out.println("Cantidad en la categoría Deportes: " + deportes.contarNoticias());

        // Búsquedas
        System.out.println("\nBÚSQUEDA");
        String autor = "Autor 2";
        System.out.print("Noticias escritas por " + autor + ": ");
        System.out.println(general.buscar(new CondicionAutor(autor)));

        // Listado de noticias y categorías
        System.out.println("\nLISTA");
        System.out.print(general.imprimirLista());

        // Copia con filtro
        System.out.println("\nCOPIA CON FILTRO");
        String titulo = "Título 1";
        System.out.print("Noticias con título '" + titulo + "': ");
        System.out.println(general.copiar(new CondicionTitulo(titulo)));
    }
}
