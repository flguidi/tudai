package tp01.e03;

public class Main {
    public static void main(String[] args) {
        // ------------------------- PUNTOS GEOMÉTRICOS -------------------------
        System.out.println("PUNTOS GEOMETRICOS");

        // Instanciación de objetos de la clase PuntoGeometrico
        PuntoGeometrico puntoSupIzq = new PuntoGeometrico(0, 3);
        PuntoGeometrico puntoInfDer = new PuntoGeometrico(2, 0);

        // Impresión de puntos por pantalla
        System.out.println("Punto sup. izq.: " + puntoSupIzq.obtenerCoordenadas());
        System.out.println("Punto inf. der.: " + puntoInfDer.obtenerCoordenadas());

        // Desplazamiento de punto en el plano
        puntoSupIzq.desplazar(1, 4);
        System.out.println("Punto sup. izq. desplazado: " + puntoSupIzq.obtenerCoordenadas());
        puntoSupIzq.desplazar(-1, -4);

        // Cálculo de distancia euclídea
        double distancia = puntoSupIzq.calcularDistancia(puntoInfDer);
        System.out.println("Distancia entre los puntos: " + distancia);


        // --------------------------- RECTÁNGULOS ---------------------------
        System.out.println("\nRECTANGULO");

        // Instanciación de objetos de la clase Rectangulo
        Rectangulo rectangulo = new Rectangulo(puntoSupIzq, puntoInfDer);

        // Algunos cálculos
        System.out.println("Area: " + rectangulo.calcularArea());
        System.out.println("Es cuadrado: " + rectangulo.esCuadrado());
        System.out.println("Orientacion: " + rectangulo.obtenerOrientacion());
    }
}
