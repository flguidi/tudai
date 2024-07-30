package tp01.e02;

public class Main {
    public static void main(String[] args) {
        // Variables que se enviarán como argumento a los constructores
        String nombre = "Heladera";
        double precioBase = 14999.99;
        String color = "Blanco";
        double consumoEnergetico = 1200;
        double peso = 45.2;

        // Instanciación de objetos de la clase Electrodomestico
        Electrodomestico heladera1 = new Electrodomestico(nombre);
        Electrodomestico heladera2 = new Electrodomestico(nombre, precioBase);
        Electrodomestico heladera3 = new Electrodomestico(nombre, precioBase, color);
        Electrodomestico heladera4 = new Electrodomestico(nombre, precioBase, color, consumoEnergetico);
        Electrodomestico heladera5 = new Electrodomestico(nombre, precioBase, color, consumoEnergetico, peso);

        // Algunos envíos de mensajes al objeto 'heladera5'
        heladera5.setColor("Gris perla");
        System.out.println("Color: " + heladera5.getColor());
        System.out.println("Es de bajo consumo: " + heladera5.esDeBajoConsumo());
        System.out.println("Balance: " + heladera5.calcularBalance());
        System.out.println("Es de alta gama: " + heladera5.esDeAltaGama());
    }
}
