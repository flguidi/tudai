package tp10.e06;

public class Huesped {
    // Atributos
    private String nombre;
    private String apellido;
    private int edad;
    private String ciudadOrigen;

    // Constructores
    public Huesped(String nombre, String apellido, int edad, String ciudadOrigen) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.ciudadOrigen = ciudadOrigen;
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }
}
