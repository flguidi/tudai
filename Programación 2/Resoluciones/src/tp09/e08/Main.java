package tp09.e08;

import tp09.e08.condiciones.*;
import tp09.e08.comparadores.*;

public class Main {
    public static void main(String[] args) {
        // CARGA DE DATOS
        // Se instancia un usuario
        Usuario u = new Usuario("@JuanPerez", 2018, "juanperez@mail.com");

        // Se instancian videos
        Video v1 = new Video("Herencia y Polimorfismo", u, 120, 1000, 854, 200, 2020);
        Video v2 = new Video("Composite", u, 130, 4500, 1220, 120, 2022);
        Video v3 = new Video("Decorator", u, 130, 4500, 1220, 120, 2022);

        // Se instancian grupos y se agregan elementos
        Grupo g1 = new Grupo("Programación", 2);
        g1.agregarElemento(v1);

        Grupo g2 = new Grupo("Patrones de diseño", 6);
        g2.agregarElemento(v2);
        g2.agregarElemento(v3);
        g1.agregarElemento(g2);

        // PRUEBA DE SERVICIOS
        // 1. Búsquedas ordenadas
        CondicionAutor condAutor = new CondicionAutor("@JuanPerez");
        ComparadorNombre compNombre = new ComparadorNombre();
        ComparadorEmail compEmail = new ComparadorEmail();

        System.out.print("Videos subidos por " + u + ": ");
        System.out.println(g1.buscar(condAutor, new ComparadorCompuesto(compNombre, compEmail)));

        // 2. Palabras clave
        v1.agregarPalabraClave("Java");
        v1.agregarPalabraClave("Programación");
        v2.agregarPalabraClave("Patrones de diseño");
        v2.agregarPalabraClave("Programación");
        v3.agregarPalabraClave("Patrones de diseño");
        v3.agregarPalabraClave("Programación");

        System.out.print("Palabras clave del grupo '" + g1 + "': ");
        System.out.println(g1.getPalabrasClave());

        System.out.print("Palabras clave del grupo '" + g2 + "': ");
        System.out.println(g2.getPalabrasClave());

        // 3. Cantidad de videos
        System.out.println("Cantidad de videos del grupo '" + g1 + "': " + g1.getCantidadVideos());
        System.out.println("Cantidad de videos del grupo '" + g2 + "': " + g2.getCantidadVideos());

        // 4. Duración de grupos
        System.out.println("Duración del grupo '" + g1 + "': " + g1.getDuracion() + "s");
        System.out.println("Duración del grupo '" + g2 + "': " + g2.getDuracion() + "s");

        // 5. Grupo sponsoreado
        Usuario administrador = new Usuario("Administrador", 2010, "administrador@mail.com");
        Video vs = new Video("Publicidad 'MisVideos'", administrador, 10, 120000, 1680, 500, 2023);
        GrupoSponsoreado gs = new GrupoSponsoreado("Publicidad 'MisVideos'", 3, vs);
        gs.agregarElemento(v1);
        gs.agregarElemento(v2);
        gs.agregarElemento(v3);
        System.out.println("Videos del grupo sponsoreado: " + gs.buscar(condAutor, compEmail));
    }
}
