package tp10.e04;

import tp10.e04.condiciones.Condicion;
import java.time.LocalDate;
import java.util.ArrayList;

public interface Gasto<T> {
    String getDescripcion();
    LocalDate getFecha();
    double getMonto();
    double calcularMontoEspecifico(Condicion<T> condicion);
    void agregarCaracteristica(String nombre, T valor);
    void eliminarCaracteristica();
    boolean tieneCaracteristica(String nombre, T valor);
    ArrayList<Gasto<T>> buscar(Condicion<T> condicion);
    String listar(int nivelIndentacion);
}
