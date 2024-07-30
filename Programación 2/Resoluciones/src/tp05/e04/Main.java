package tp05.e04;

public class Main {
    public static void main(String[] args) {
        // Se crea un país, una provincia y una ciudad
        Pais argentina = new Pais("Argentina");
        Provincia entreRios = new Provincia("Entre Ríos");
        Ciudad parana = new Ciudad("Paraná", 280000, 500000);

        // Se añaden elementos
        entreRios.agregarCiudad(parana);
        argentina.agregarProvincia(entreRios);

        // Se instancian contribuyentes y se agregan a la ciudad
        Contribuyente cSimple = new Contribuyente("Juan Pérez", "A-001", 10000);
        ContribuyenteEspecial cComerciante = new ContribuyenteEspecial("Martina Rodríguez", "C-001", 10000, 0.5, 12000, 3.5);
        ContribuyenteEspecial cProgramador = new ContribuyenteEspecial("Pablo Blanco", "P-001", 10000, 0.2, 50000, 0.02);
        parana.agregarContribuyente(cSimple);
        parana.agregarContribuyente(cComerciante);
        parana.agregarContribuyente(cProgramador);

        // Se imprime información
        System.out.println(argentina + "\n");
        System.out.println(entreRios + "\n");
        System.out.println(parana + "\n");
    }
}
