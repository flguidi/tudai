package recuperatorio_2022_11_10;

import recuperatorio_2022_11_10.condiciones.*;
import java.util.ArrayList;

public class Suscriptor {
    // Atributos
    private String nombre;
    private String apellido;
    private String email;
    private ArrayList<Noticia> noticiasRecibidas;
    private Condicion interes;

    // Constructores
    public Suscriptor(String nombre, String apellido, String email, Condicion interes) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.noticiasRecibidas = new ArrayList<>();
        this.interes = interes;
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Condicion getInteres() {
        return interes;
    }

    public void setInteres(Condicion interes) {
        this.interes = interes;
    }

    public void agregarInteres(Condicion interes) {
        Condicion interesCompuesto = new CondicionAnd(this.interes, interes);
        this.setInteres(interesCompuesto);
    }

    public void recibirNoticia(Noticia noticia) {
        if (interes.esCumplidaPor(noticia) && !noticiasRecibidas.contains(noticia))
            noticiasRecibidas.add(noticia);
    }
}
