package tp07.e01;

import java.util.ArrayList;

public class Agroquimico {
    // Atributos
    private String nombre;
    private ArrayList<Cultivo> cultivosDesaconsejados;
    private ArrayList<String> estadosPatologicosTratables;

    // Constructores
    public Agroquimico(String nombre) {
        this.nombre = nombre;
        this.cultivosDesaconsejados = new ArrayList<>();
        this.estadosPatologicosTratables = new ArrayList<>();
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarCultivoDesaconsejado(Cultivo cultivo) {
        if (!cultivosDesaconsejados.contains(cultivo))
            cultivosDesaconsejados.add(cultivo);
    }

    public void eliminarCultivoDesaconsejado(Cultivo cultivo) {
        cultivosDesaconsejados.remove(cultivo);
    }

    public void agregarEstadoPatologicoTratable(String estadoPatologico) {
        if (!estadosPatologicosTratables.contains(estadoPatologico))
            estadosPatologicosTratables.add(estadoPatologico);
    }

    public void eliminarEstadoPatologicoTratable(String estadoPatologico) {
        estadosPatologicosTratables.remove(estadoPatologico);
    }

    public boolean puedeTratar(Enfermedad enfermedad) {
        for (int i = 0; i < estadosPatologicosTratables.size(); i++) {
            if (!enfermedad.poseeEstadoPatologico(estadosPatologicosTratables.get(i)))
                return false;
        }
        return true;
    }

    public boolean puedeUtilizarseEn(Cultivo cultivo) {
        return !cultivosDesaconsejados.contains(cultivo);
    }

    @Override
    public boolean equals(Object o) {
        try {
            Agroquimico otroAgroquimico = (Agroquimico) o;
            return this.getNombre().equals(otroAgroquimico.getNombre());
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return nombre;
    }
}
