package tp03.e01;

public class Main {
    public static void main(String[] args) {
        // Se instancia la empresa consultora
        EmpresaConsultora consultora = new EmpresaConsultora("Consultora Tandil");

        // Se instancia un empleado y se agrega a la empresa
        Empleado empleado = new Empleado("Juan Pérez");
        consultora.agregarEmpleado(empleado);

        // Se instancia personas encuestadas
        PersonaEncuestada personaEncuestada1 = new PersonaEncuestada("Pablo Gómez", "12345678");
        PersonaEncuestada personaEncuestada2 = new PersonaEncuestada("Pedro Blanco", "23456789");

        // Se crean encuestas y preguntas
        Encuesta encuesta1 = new Encuesta(empleado, personaEncuestada1);
        Encuesta encuesta2 = new Encuesta(empleado, personaEncuestada2);

        encuesta1.agregarPregunta("Pregunta 1.1");
        encuesta1.agregarPregunta("Pregunta 1.2");
        encuesta2.agregarPregunta("Pregunta 2.1");
        encuesta2.agregarPregunta("Pregunta 2.2");

        // Se agregan las encuestas a la consultora
        consultora.agregarEncuesta(encuesta1);
        consultora.agregarEncuesta(encuesta2);

        // Se completan las encuestas
        encuesta1.completar();
        encuesta2.completar();

        // Impresión de información
        System.out.println(consultora);
        System.out.println(empleado);
        System.out.println(personaEncuestada1);
        System.out.println(personaEncuestada2);
        System.out.println(encuesta1);
        System.out.println(encuesta2);

        // Se trata de completar la misma encuesta
        encuesta1.completar();
    }
}
