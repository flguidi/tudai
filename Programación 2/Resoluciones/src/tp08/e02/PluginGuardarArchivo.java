package tp08.e02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PluginGuardarArchivo implements Plugin {
    @Override
    public void ejecutar(String texto) {
        String usuario = "Franco";
        String path = "C:\\Users\\" + usuario + "\\Downloads\\archivoDestino.txt";
        try {
            Files.write(Paths.get(path), texto.getBytes());
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
