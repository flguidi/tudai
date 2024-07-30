package tp05.e06;

public class Main {
    public static void main(String[] args) {
        // Se instancian evaluadores y se les agrega conocimientos
        Evaluador e1 = new Evaluador("Juan Pérez");
        e1.agregarConocimiento("Estructuras de datos");
        e1.agregarConocimiento("Algoritmos de ordenamiento");

        Evaluador e2 = new Evaluador("Carla Rodríguez");
        e2.agregarConocimiento("Visualización");
        e2.agregarConocimiento("Redes de comunicación");

        // Se instancian trabajos y se les agrega palabras claves
        Trabajo t1 = new Trabajo("Programación estructurada","Artículo");
        t1.agregarPalabraClave("Estructuras de datos");

        Trabajo t2 = new Trabajo("Ordenamiento por inserción","Resúmen");
        t2.agregarPalabraClave("Estructuras de datos");
        t2.agregarPalabraClave("Algoritmos de ordenamiento");

        Poster t3 = new Poster("Operaciones y visualización","Póster");
        t3.agregarPalabraClave("Operaciones");
        t3.agregarPalabraClave("Visualisación");

        // Se instancia un comité y se agregan evaluadores y trabajos
        Comite comite = new Comite();
        comite.agregarEvaluador(e1);
        comite.agregarEvaluador(e2);
        comite.agregarTrabajo(t1);
        comite.agregarTrabajo(t2);
        comite.agregarTrabajo(t3);

        // Se imprime información de evaluadores y trabajos
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);

        // Se verifica si un evaluador es apto para evaluar determinado trabajo
        System.out.println(e1.getNombre() + " puede evaluar '" + t1.getTitulo() + "': " + e1.puedeEvaluar(t1));
        System.out.println(e1.getNombre() + " puede evaluar '" + t2.getTitulo() + "': " + e1.puedeEvaluar(t2));
        System.out.println(e1.getNombre() + " puede evaluar '" + t3.getTitulo() + "': " + e1.puedeEvaluar(t3));

        System.out.println(e2.getNombre() + " puede evaluar '" + t1.getTitulo() + "': " + e2.puedeEvaluar(t1));
        System.out.println(e2.getNombre() + " puede evaluar '" + t2.getTitulo() + "': " + e2.puedeEvaluar(t2));
        System.out.println(e2.getNombre() + " puede evaluar '" + t3.getTitulo() + "': " + e2.puedeEvaluar(t3));
    }
}
