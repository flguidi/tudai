package tp08.e02;

public class PluginEliminarPalabra implements Plugin {
    // Atributos
    private String palabra;

    // Constructores
    public PluginEliminarPalabra(String palabra) {
        this.palabra = palabra;
    }

    // Métodos
    @Override
    public void ejecutar(String texto) {
        String resultado = texto.replace(palabra, "");
        System.out.println(resultado);
    }
}
