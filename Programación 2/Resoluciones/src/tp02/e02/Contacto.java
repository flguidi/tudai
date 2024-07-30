package tp02.e02;

public class Contacto {
    // Atributos
    private String nombre;
    private String numero;
    private String email;

    // Constructores
    public Contacto(String nombre, String numeroTelefonico, String mail) {
        this.nombre = nombre;
        this.numero = numeroTelefonico;
        this.email = mail;
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroTelefonico() {
        return numero;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numero = numeroTelefonico;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}