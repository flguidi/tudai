package tp05.e02;

import java.util.ArrayList;

public class CasaExigente extends Casa {
    // Constructores
    public CasaExigente(String nombre, int capacidad) {
        super(nombre, capacidad);
    }

    public CasaExigente(String nombre, int capacidad, ArrayList<String> cualidadesRequeridas) {
        super(nombre, capacidad, cualidadesRequeridas);
    }

    // Métodos
    @Override
    public boolean aceptaA(Alumno alumno) {
        return super.aceptaA(alumno) && alumno.tieneFamiliarEn(this);
    }
}
