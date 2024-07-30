package tp09.e02;

import tp09.e02.comparadores.*;
import tp09.e02.condiciones.*;
import java.time.LocalDate;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // Se crea la carpeta raíz
        Carpeta raiz = new Carpeta("\\");

        // Se crean carpetas y archivos
        Carpeta tudai = new Carpeta("TUDAI");
        raiz.agregarElemento(tudai);

        Carpeta prog2 = new Carpeta("Programación 2");
        tudai.agregarElemento(prog2);

        Archivo tp1 = new Archivo("Programación 2 - TP01.pdf", 140);
        Archivo tp2 = new Archivo("Programación 2 - TP02.pdf", 155);
        prog2.agregarElemento(tp1);
        prog2.agregarElemento(tp2);

        // Se crea un archivo comprimido y se agregan elementos
        Comprimido parciales = new Comprimido("Parciales.rar", 0.7);
        prog2.agregarElemento(parciales);

        Archivo parcial1 = new Archivo("Parcial 01.pdf", 400);
        Archivo parcial2 = new Archivo("Parcial 02.pdf", 600);
        parciales.agregarElemento(parcial1);
        parciales.agregarElemento(parcial2);

        // Se agrega un acceso directo en la raíz que apunta a un archivo en 'Primer año'
        AccesoDirecto linkTP1 = new AccesoDirecto(tp1);
        raiz.agregarElemento(linkTP1);

        // Se crea una carpeta y se agregan imágenes
        Carpeta imagenes = new Carpeta("Imágenes");
        raiz.agregarElemento(imagenes);

        Archivo img1 = new Archivo("Casa.jpg", 800);
        Archivo img2 = new Archivo("Perro.jpg", 960);
        Archivo img3 = new Archivo("Árbol.png", 1600);
        imagenes.agregarElemento(img1);
        imagenes.agregarElemento(img2);
        imagenes.agregarElemento(img3);

        // Se imprime la información de la carpeta raíz
        System.out.println("\nRaíz:");
        System.out.println(raiz.getInformacion());

        // Se imprime la información de algunos archivos
        System.out.println("\n" + tp1.getInformacion());
        System.out.println("\n" + linkTP1.getInformacion());
        System.out.println("\n" + parciales.getInformacion());
        System.out.println("\n" + parcial2.getInformacion());

        // Búsquedas
        System.out.println("\nBUSQUEDAS:");
        System.out.println("Búsqueda de nombres que contengan la subcadena dada (orden alfabético):");
        Condicion condNombre = new CondicionNombreParcial("Prog");
        Comparator<ElementoSA> compNombre = new ComparadorNombre();
        System.out.println(raiz.buscar(condNombre, compNombre));

        System.out.println("Búsqueda de archivos con tamaño mayor al dado (orden de tamaño):");
        Condicion condTamanio = new CondicionTamanio(900);
        Comparator<ElementoSA> compTamanio = new ComparadorTamanio();
        System.out.println(raiz.buscar(condTamanio, compTamanio));

        System.out.println("Búsqueda de archivos creados antes de la fecha dada (orden de fecha):");
        Condicion condFecha = new CondicionFecha(LocalDate.of(2024, 8, 20));
        Comparator<ElementoSA> compFecha = new ComparadorFecha();
        System.out.println(raiz.buscar(condFecha, compFecha));

        System.out.println("Combinaciones lógicas:");
        System.out.println(raiz.buscar(new CondicionOr(condNombre, condTamanio), compTamanio));
    }
}
