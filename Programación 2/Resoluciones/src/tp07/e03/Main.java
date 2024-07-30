package tp07.e03;

import tp07.e03.condiciones.*;

public class Main {
    public static void main(String[] args) {
        // Se instancia un vivero
        Vivero vivero = new Vivero();

        // Se instancian plantas, se añaden atributos y se agregan al vivero
        Planta planta1 = new Planta("Epipremnum aureum", "Epipremnum", "Araceae", "Monocotyledoneae", true, 3, 4);
        planta1.agregarNombreVulgar("Potus");
        planta1.agregarNombreVulgar("Pothus");
        planta1.agregarNombreVulgar("Potos");
        System.out.println(planta1.obtenerInformacion());

        Planta planta2 = new Planta("Rosa gallica", "Angiosperma", "Rosaceae", "Magnoliopsida", false, 8, 2);
        planta2.agregarNombreVulgar("Rosa roja");
        planta2.agregarNombreVulgar("Rosa de Galia");
        System.out.println(planta2.obtenerInformacion());

        vivero.agregarPlanta(planta1);
        vivero.agregarPlanta(planta2);

        // Se realizan búsquedas
        System.out.print("a. Búsqueda por nombre científico: ");
        System.out.println(vivero.buscarPlantas(new CondicionNombreCientifico("auereum")));

        System.out.print("b. Búsqueda por nombre vulgar: ");
        System.out.println(vivero.buscarPlantas(new CondicionNombreVulgar("Lengua de suegra")));

        System.out.print("c. Búsqueda por clasificación superior: ");
        System.out.println(vivero.buscarPlantas(new CondicionClasificacion("Crassula")));

        System.out.print("d. Nivel de sol superior a 5 y riego inferior a 3: ");
        Condicion cond1 = new CondicionSol(5);
        Condicion cond2 = new CondicionNot(new CondicionRiego(3));
        System.out.println(vivero.buscarPlantas(new CondicionAnd(cond1, cond2)));

        System.out.print("e. Nivel de sol inferior a 4 y riego superior a 4: ");
        cond1 = new CondicionNot(new CondicionSol(4));
        cond2 = new CondicionRiego(4);
        System.out.println(vivero.buscarPlantas(new CondicionAnd(cond1, cond2)));

        System.out.print("f. Plantas de interior de poco riego (menor a 4): ");
        cond1 = new CondicionDeInterior(true);
        cond2 = new CondicionNot(new CondicionRiego(4));
        System.out.println(vivero.buscarPlantas(new CondicionAnd(cond1, cond2)));

        System.out.print("g. Búsqueda por nombre científico o nombre vulgar: ");
        cond1 = new CondicionNombreCientifico("aureum");
        cond2 = new CondicionNombreVulgar("Lengua de suegra");
        System.out.println(vivero.buscarPlantas(new CondicionOr(cond1, cond2)));
    }
}
