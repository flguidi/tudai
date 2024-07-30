package tp05.e02;

import java.util.ArrayList;

public class CasaConEnemigos extends Casa {
    // Atributos
    private ArrayList<Casa> casasEnemigas;

    // Constructores
    public CasaConEnemigos(String nombre, int capacidad) {
        super(nombre, capacidad);
        this.casasEnemigas = new ArrayList<>();
    }

    public CasaConEnemigos(String nombre, int capacidad, ArrayList<String> cualidadesRequeridas,
                           ArrayList<Casa> casasEnemigas) {
        super(nombre, capacidad, cualidadesRequeridas);
        this.casasEnemigas = casasEnemigas;
    }

    // Métodos
    public void agregarCasaEnemiga(Casa casaEnemiga) {
        if (!this.casasEnemigas.contains(casaEnemiga))
            this.casasEnemigas.add(casaEnemiga);
    }

    public void eliminarCasaEnemiga(Casa casaEnemiga) {
        this.casasEnemigas.remove(casaEnemiga);
    }

    @Override
    public boolean aceptaA(Alumno alumno) {
        if (super.aceptaA(alumno)) {
            for (Casa casaEnemiga : this.casasEnemigas)
                if (casaEnemiga.aceptaA(alumno))
                    return false;

            return true;
        }
        return false;
    }
}
