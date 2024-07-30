package tp01.e04;

public class Main {
    public static void main(String[] args) {
        // Creación de puntos geométricos
        PuntoGeometrico puntoSupIzq = new PuntoGeometrico(0, 3);
        PuntoGeometrico puntoInfDer = new PuntoGeometrico(2, 0);

        // Creación de rectángulos
        Rectangulo rectangulo1 = new Rectangulo(puntoSupIzq, puntoInfDer);
        Rectangulo rectangulo2 = new Rectangulo(puntoSupIzq, 4, 3);

        // Envío de mensajes
        // Comparación de áreas
        System.out.println("Area de 'rectangulo1': " + rectangulo1.calcularArea());
        System.out.println("Area de 'rectangulo2': " + rectangulo2.calcularArea());
        System.out.println("Comparacion de area entre 'rectangulo1' y 'rectangulo2': "
                + rectangulo1.compararArea(rectangulo2));

        // Desplazamiento de 'rectangulo2'
        System.out.println("Vertices de 'rectangulo2':");
        System.out.println("Punto A: " + rectangulo2.getPuntoA().obtenerStringCoordenadas());
        System.out.println("Punto B: " + rectangulo2.getPuntoB().obtenerStringCoordenadas());
        System.out.println("Punto C: " + rectangulo2.getPuntoC().obtenerStringCoordenadas());
        System.out.println("Punto D: " + rectangulo2.getPuntoD().obtenerStringCoordenadas());

        rectangulo2.desplazar(1, 1);

        System.out.println("Vertices de 'rectangulo2' desplazado:");
        System.out.println("Punto A: " + rectangulo2.getPuntoA().obtenerStringCoordenadas());
        System.out.println("Punto B: " + rectangulo2.getPuntoB().obtenerStringCoordenadas());
        System.out.println("Punto C: " + rectangulo2.getPuntoC().obtenerStringCoordenadas());
        System.out.println("Punto D: " + rectangulo2.getPuntoD().obtenerStringCoordenadas());
    }
}
