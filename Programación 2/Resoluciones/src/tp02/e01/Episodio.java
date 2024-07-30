package tp02.e01;

public class Episodio {
    // Atributos
    private String titulo;
    private String descripcion;
    private boolean visto;
    private int calificacion;

    // Constructores
    public Episodio(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.visto = false;
        this.calificacion = -1;
    }

    // Métodos
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean seVio() {
        return visto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        if (calificacion >= 1 && calificacion <= 5) {
            this.calificacion = calificacion;
            this.visto = true;
        } else {
            System.out.println("Calificación incorrecta");
        }
    }
}
