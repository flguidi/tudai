package tp08.e02;

public class PluginContadorPalabras implements Plugin {
    // Atributos
    private int contador;

    // Constructores
    public PluginContadorPalabras() {
        this.contador = 0;
    }

    // Métodos
    @Override
    public void ejecutar(String texto) {
        if (texto != null) {
            String[] palabras = texto.split("\\s+");
            contador = palabras.length;
        }
        System.out.println(contador);
    }
}
