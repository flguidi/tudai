package tp09.e03;

import tp09.e03.condiciones.Condicion;
import java.util.ArrayList;
import java.util.Comparator;

public class SistemaElectoral extends ElementoElectoral {
    // Atributos
    SitioElectoral raiz;
    ArrayList<Candidato> candidatos;

    // Constructores
    public SistemaElectoral() {
        this.raiz = new SitioElectoral();
        this.candidatos = new ArrayList<>();
    }

    // Métodos
    public void agregarSitioElectoral(SitioElectoral sitio) {
        raiz.agregarSitioElectoral(sitio);
    }

    public void eliminarSitioElectoral(SitioElectoral sitio) {
        raiz.eliminarSitioElectoral(sitio);
    }

    public void agregarCandidato(Candidato candidato) {
        if (!candidatos.contains(candidato))
            candidatos.add(candidato);
    }

    public void eliminarCandidato(Candidato candidato) {
        candidatos.remove(candidato);
    }

    public ArrayList<Candidato> obtenerCandidatos(Comparator<Candidato> comparador) {
        ArrayList<Candidato> lista = new ArrayList<>(candidatos);
        lista.sort(comparador);
        return lista;
    }

    @Override
    public int contarVotos() {
        return raiz.contarVotos();
    }

    public double calcularPorcentaje(Condicion condicion) {
        return raiz.calcularPorcentaje(condicion);
    }

    @Override
    public int filtrar(Condicion condicion) {
        return raiz.filtrar(condicion);
    }
}
