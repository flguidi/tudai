package tp04.e06;

public class PersonaAsociada {
    // Atributos
    private String nombre;
    private String apellido;
    private int edad;
    private String rol;

    // Constructores
    public PersonaAsociada(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + "\n" +
                "Apellido: " + this.apellido + "\n" +
                "Edad: " + this.edad + "\n" +
                "Rol: " + this.rol;
    }
}
