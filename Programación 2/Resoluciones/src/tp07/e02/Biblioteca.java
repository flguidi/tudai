package tp07.e02;

import tp07.e02.condiciones.Condicion;
import java.util.ArrayList;

public class Biblioteca {
    // Atributos
    private ArrayList<Documento> documentos;

    // Constructores
    public Biblioteca() {
        this.documentos = new ArrayList<>();
    }

    // Métodos
    public void agregarDocumento(Documento documento) {
        documentos.add(documento);
    }

    public void eliminarDocumento(Documento documento) {
        documentos.remove(documento);
    }

    public ArrayList<Documento> buscarDocumentos(Condicion condicion) {
        ArrayList<Documento> lista = new ArrayList<>();
        for (int i = 0; i < documentos.size(); i++) {
            Documento documento = documentos.get(i);
            if (condicion.esCumplidaPor(documento))
                lista.add(documento);
        }
        return lista;
    }
}
