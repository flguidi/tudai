package tp05.e02;

public class Main {
    public static void main(String[] args) {
        // Se instancian casas
        CasaExigente gryffindor = new CasaExigente("Gryffindor", 100);
        CasaConEnemigos slytherin = new CasaConEnemigos("Slytherin", 100);
        Casa ravenclaw = new Casa("Ravenclaw", 100);
        Casa hafflepuff = new Casa("Hafflepuff", 100);

        // Se agregan cualidades requeridas a las casas
        gryffindor.agregarCualidadRequerida("Valentía");
        slytherin.agregarCualidadRequerida("Inteligencia");
        ravenclaw.agregarCualidadRequerida("Honestidad");
        hafflepuff.agregarCualidadRequerida("Lealtad");

        // Se instancian alumnos
        Alumno harry = new Alumno("Harry Potter");
        Alumno draco = new Alumno("Draco Malfoy");
        Alumno luna = new Alumno("Luna Lovegood");
        Alumno cedric = new Alumno("Cedric Diggory");

        // Se agregan cualidades a los alumnos
        harry.agregarCualidad("Valentía");
        harry.agregarCualidad("Inteligencia");

        draco.agregarCualidad("Inteligencia");
        draco.agregarCualidad("Astucia");

        luna.agregarCualidad("Honestidad");
        luna.agregarCualidad("Valentía");

        cedric.agregarCualidad("Lealtad");
        cedric.agregarCualidad("Inteligencia");

        // Se agrega un familiar de Harry a Gryffindor
        Alumno james = new Alumno("James Potter");
        harry.agregarFamiliar(james);
        james.setCasa(gryffindor);

        // Se imprimen los datos de los alumnos
        System.out.println(harry);
        System.out.println(draco);
        System.out.println(luna);
        System.out.println(cedric);

        // Se verifica si Gryffindor acepta a determinados alumnos
        System.out.println("¿Gryffindor acepta a Harry? " + gryffindor.aceptaA(harry));
        System.out.println("¿Gryffindor acepta a Luna? " + gryffindor.aceptaA(luna));

        // Se agrega una casa enemiga a Slytherin
        slytherin.agregarCasaEnemiga(gryffindor);

        // Se verifica si Slytherin acepta a determinados alumnos
        System.out.println("¿Slytherin acepta a Draco? " + slytherin.aceptaA(draco));
        System.out.println("¿Slytherin acepta a Cedric? " + slytherin.aceptaA(cedric));
        System.out.println("¿Slytherin acepta a Harry? " + slytherin.aceptaA(harry));
    }
}
