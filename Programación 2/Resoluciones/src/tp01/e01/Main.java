package tp01.e01;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Variables que se enviarán como argumentos a los constructores
        String nombre = "Juan";
        String apellido = "Pérez";
        int edad = 30;
        int dni = 12345678;
        String sexo = "Masculino";
        LocalDate fechaNacimiento = LocalDate.of(1965, 8, 19);
        double peso = 70.5;
        double altura = 1.7;

        // Instanciación de objetos de la clase Persona
        Persona persona1 = new Persona(dni);
        Persona persona2 = new Persona(dni, nombre, apellido);
        Persona persona3 = new Persona(dni, nombre, apellido, fechaNacimiento);
        Persona persona4 = new Persona(dni, nombre, apellido, fechaNacimiento, edad, sexo);
        Persona persona5 = new Persona(dni, nombre, apellido, fechaNacimiento, edad, sexo, peso, altura);

        // Envío de mensajes al objeto 'persona5'
        persona5.mostrarInformacion();
        System.out.println("IMC: " + persona5.calcularIMC());
        System.out.println("Está en forma: " + persona5.estaEnForma());
        System.out.println("Está cumpliendo años: " + persona5.estaCumpliendoAnios());
        System.out.println("Es mayor de edad: " + persona5.esMayorDeEdad());
        System.out.println("Puede votar: " + persona5.puedeVotar());
        System.out.println("Tiene edad coherente: " + persona5.tieneEdadCoherente());
    }
}