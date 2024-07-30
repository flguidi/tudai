package tp08.e02;

public class PluginContadorOcurrencias implements Plugin {
    // Atributos
    private String palabraBuscada;
    private int contador;

    // Constructores
    public PluginContadorOcurrencias(String palabraBuscada) {
        this.palabraBuscada = palabraBuscada;
        this.contador = 0;
    }

    // Métodos
    @Override
    public void ejecutar(String texto) {
        if (texto != null) {
            String[] palabras = texto.split("\\s+");
            for (int i = 0; i < palabras.length; i++) {
                if (palabras[i].equalsIgnoreCase(palabraBuscada))
                    contador++;
            }
        }
        System.out.println(contador);
    }
}
