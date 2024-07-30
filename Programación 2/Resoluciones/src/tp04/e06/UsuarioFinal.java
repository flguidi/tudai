package tp04.e06;

public class UsuarioFinal extends PersonaAsociada {
    // Atributos
    private String nombreUsuario;
    private String password;

    // Constructores
    public UsuarioFinal(String nombre, String apellido, int edad, String nombreUsuario, String password) {
        super(nombre, apellido, edad);
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.setRol("Usuario final");
    }

    // Métodos
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Nombre de usuario: " + this.nombreUsuario + "\n" +
                "Contraseña: " + this.password;
    }
}
