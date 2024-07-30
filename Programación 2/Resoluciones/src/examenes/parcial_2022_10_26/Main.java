package parcial_2022_10_26;

import parcial_2022_10_26.condiciones.*;

public class Main {
    public static void main(String[] args) {
        // Se instancian noticias simples y compuestas
        Seccion seccion = new Seccion(4);
        Seccion subseccion1 = new Seccion(4);
        Seccion subseccion2 = new Seccion(4);

        Noticia n1 = new Noticia("Ganó Argentina", "Juan Pérez", "Ganó Argentina 3-0 contra Bolivia", "Deportes");
        Noticia n2 = new Noticia("Habrá balotage", "María Gómez", "¿Milei o Massa?", "Política");
        Noticia n3 = new Noticia("Accidente en panamericana", "Tito Gutiérrez", "Al menos cuatro heridos", "Urgente");

        // Se arma la estructura de árbol
        subseccion1.agregarElementoPortal(n1);
        subseccion1.agregarElementoPortal(n2);
        seccion.agregarElementoPortal(subseccion1);

        subseccion2.agregarElementoPortal(n3);
        seccion.agregarElementoPortal(subseccion2);

        // Se agregan palabras claves a las noticias
        n1.agregarPalabraClave("Argentina");
        n1.agregarPalabraClave("Fútbol");

        n2.agregarPalabraClave("Elecciones");
        n2.agregarPalabraClave("Argentina");

        n3.agregarPalabraClave("Accidente");
        n3.agregarPalabraClave("Tránsito");

        System.out.println("Palabras clave");
        System.out.println("Noticia 1: " + n1.obtenerPalabrasClaves());
        System.out.println("Noticia 2: " + n2.obtenerPalabrasClaves());
        System.out.println("Noticia 3: " + n3.obtenerPalabrasClaves());

        System.out.print("\nPalabras clave de Subsección 1: ");
        System.out.println(subseccion1.obtenerPalabrasClaves());

        // Filtros
        System.out.print("\nFiltro de noticias con título que contenta 'na': ");
        System.out.println(seccion.filtrar(new CondicionTitulo("na")));

        // Secciones especiales
        System.out.println("\nSección especial:");
        SeccionEspecial seccionEspecial = new SeccionEspecial(4, "Resúmen", 4);
        seccionEspecial.agregarElementoPortal(n1);
        seccionEspecial.agregarElementoPortal(n2);
        seccionEspecial.agregarElementoPortal(n3);

        System.out.println("Categoría: " + seccionEspecial.getCategoria());
        System.out.println("Palabras claves: " + seccionEspecial.obtenerPalabrasClaves());
    }
}
