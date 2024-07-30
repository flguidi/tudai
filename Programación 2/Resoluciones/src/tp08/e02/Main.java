package tp08.e02;

public class Main {
    public static void main(String[] args) {
        // Se instancia un procesador de texto y se le asigna un texto
        String texto = "Está amaneciendo y hace mucho calor.";
        System.out.println("Texto: " + texto);
        ProcesadorTexto procesadorTexto = new ProcesadorTexto(texto);

        // Se instancian y ejecutan plugins
        System.out.println("CONTADOR DE PALABRAS");
        procesadorTexto.ejecutarPlugin(new PluginContadorPalabras());

        System.out.println("CONTADOR DE OCURRENCIAS");
        procesadorTexto.ejecutarPlugin(new PluginContadorOcurrencias("amaneciendo"));

        System.out.println("REEMPLAZO DE PALABRAS");
        procesadorTexto.ejecutarPlugin(new PluginReemplazoTexto("calor", "frío"));

        System.out.println("ELIMINACION DE PALABRAS");
        procesadorTexto.ejecutarPlugin(new PluginEliminarPalabra("mucho"));

        System.out.println("GUARDADO DE TEXTO EN ARCHIVO EXTERNO");
        procesadorTexto.ejecutarPlugin(new PluginGuardarArchivo());
    }
}
