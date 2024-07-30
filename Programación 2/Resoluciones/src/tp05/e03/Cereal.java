package tp05.e03;

import java.util.ArrayList;

public class Cereal {
    // Atributos
    private String nombre;
    private String tipo;
    private ArrayList<String> mineralesNecesarios;

    // Constructores
    public Cereal(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.mineralesNecesarios = new ArrayList<>();
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void agregarMineralNecesario(String mineral) {
        if (!this.mineralesNecesarios.contains(mineral))
            this.mineralesNecesarios.add(mineral);
    }

    public void eliminarMineralNecesario(String mineral) {
        this.mineralesNecesarios.remove(mineral);
    }

    public boolean sePuedeSembrarEn(Lote lote) {
        for (String mineralNecesario : mineralesNecesarios) {
            if (!lote.tieneMineral(mineralNecesario))
                return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;

        Cereal otroCereal = (Cereal) o;
        return this.getNombre().equals(otroCereal.getNombre());
    }
}
