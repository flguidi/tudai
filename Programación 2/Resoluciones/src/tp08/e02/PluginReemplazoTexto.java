package tp08.e02;

public class PluginReemplazoTexto implements Plugin {
    // Atributos
    private String palabraOriginal;
    private String palabraNueva;

    // Constructores
    public PluginReemplazoTexto(String palabraOriginal, String palabraNueva) {
        this.palabraOriginal = palabraOriginal;
        this.palabraNueva = palabraNueva;
    }

    // Métodos
    @Override
    public void ejecutar(String texto) {
        if (texto != null) {
            String resultado = texto.replace(palabraOriginal, palabraNueva);
            System.out.println(resultado);
        }
    }
}
