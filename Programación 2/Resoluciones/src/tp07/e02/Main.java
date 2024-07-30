package tp07.e02;

import tp07.e02.condiciones.*;

public class Main {
    public static void main(String[] args) {
        // Se instancia una biblioteca de documentos
        Biblioteca biblioteca = new Biblioteca();

        // Se instancian documentos, y se agregan autores y palabras clave
        Documento d1 = new Documento("Documento 1", "Texto del documento 1");
        d1.agregarAutor("Juan Pérez");
        d1.agregarAutor("Martina Rodríguez");
        d1.agregarPalabraClave("Palabra clave 1");
        d1.agregarPalabraClave("Palabra clave 2");
        d1.agregarPalabraClave("Palabra clave 3");
        System.out.println(d1.obtenerInformacion());

        Documento d2 = new Documento("Documento 2", "Texto del documento 2");
        d2.agregarAutor("Pedro González");
        d2.agregarAutor("Martina Rodríguez");
        d2.agregarPalabraClave("Palabra clave 4");
        d2.agregarPalabraClave("Palabra clave 5");
        d2.agregarPalabraClave("Palabra clave 6");
        System.out.println(d2.obtenerInformacion());

        // Se agregan los documentos a la biblioteca
        biblioteca.agregarDocumento(d1);
        biblioteca.agregarDocumento(d2);

        // Se realizan búsquedas según distintos criterios
        System.out.print("a. Documentos con título exacto: ");
        System.out.println(biblioteca.buscarDocumentos(new CondicionTituloIgual("Documento 1")));

        System.out.print("b. Documentos con título parcial: ");
        System.out.println(biblioteca.buscarDocumentos(new CondicionTituloParcial("Doc")));

        System.out.print("c. Documentos con palabra clave dada: ");
        System.out.println(biblioteca.buscarDocumentos(new CondicionPalabraClave("Palabra clave 1")));

        System.out.print("d. Documentos sin palabras clave: ");
        System.out.println(biblioteca.buscarDocumentos(new CondicionSinPalabrasClave()));

        System.out.print("e. Documentos con un determinado autor: ");
        System.out.println(biblioteca.buscarDocumentos(new CondicionAutor("Martina Rodríguez")));

        System.out.print("f. Documentos según contenido: ");
        System.out.println(biblioteca.buscarDocumentos(new CondicionContenido("Texto")));

        System.out.print("g. Documentos con un mínimo de palabras dado: ");
        System.out.println(biblioteca.buscarDocumentos(new CondicionContenidoMin(20)));

        System.out.print("h. Documentos con título exacto y un determinado autor: ");
        Condicion cond1 = new CondicionTituloIgual("Documento 1");
        Condicion cond2 = new CondicionAutor("Juan Pérez");
        System.out.println(biblioteca.buscarDocumentos(new CondicionAnd(cond1, cond2)));
    }
}
