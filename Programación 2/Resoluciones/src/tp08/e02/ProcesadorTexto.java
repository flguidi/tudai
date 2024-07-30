package tp08.e02;

public class ProcesadorTexto {
    // Atributos
    private String texto;

    // Constructores
    public ProcesadorTexto(String texto) {
        this.texto = texto;
    }

    // Métodos
    public void ejecutarPlugin(Plugin plugin) {
        if (plugin != null)
            plugin.ejecutar(texto);
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
