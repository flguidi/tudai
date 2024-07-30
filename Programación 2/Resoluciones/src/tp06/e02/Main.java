package tp06.e02;

public class Main {
    public static void main(String[] args) {
        // Se instancia un centro de cómputos
        CentroComputos centroComputos = new CentroComputos();

        // Se instancian computadoras y procesos
        Computadora pc1 = new Computadora("pc1", 1200.0);
        Computadora pc2 = new Computadora("pc2", 1150.0);
        Computadora pc3 = new Computadora("pc3", 1400.0);
        Proceso pr1 = new Proceso("pr1", 13);
        Proceso pr2 = new Proceso("pr2", 17.5);
        Proceso pr3 = new Proceso("pr3", 14.5);

        // Se agregan procesos y computadoras
        centroComputos.agregarProceso(pr1);
        centroComputos.agregarProceso(pr2);
        System.out.println(centroComputos + "\n");

        centroComputos.agregarComputadora(pc1);
        centroComputos.agregarComputadora(pc2);
        centroComputos.agregarComputadora(pc3);
        System.out.println(centroComputos + "\n");

        centroComputos.agregarProceso(pr3);
        System.out.println(centroComputos + "\n");
    }
}
