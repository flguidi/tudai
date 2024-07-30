package tp05.e03;

import java.util.ArrayList;

public class Cooperativa {
    // Atributos
    private String nombre;
    private ArrayList<Cereal> cereales;
    private ArrayList<Lote> lotes;
    private ArrayList<String> mineralesPrimarios;

    // Constructores
    public Cooperativa(String nombre) {
        this.nombre = nombre;
        this.cereales = new ArrayList<>();
        this.lotes = new ArrayList<>();
        this.mineralesPrimarios = new ArrayList<>();
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public void agregarLote(Lote lote) {
        if (!this.lotes.contains(lote))
            this.lotes.add(lote);
    }

    public void eliminarLote(Lote lote) {
        this.lotes.remove(lote);
    }

    public void agregarCereal(Cereal cereal) {
        if (!this.cereales.contains(cereal))
            this.cereales.add(cereal);
    }

    public void eliminarCereal(Cereal cereal) {
        this.cereales.remove(cereal);
    }

    public String getCerealesPermitidosEn(Lote lote) {
        String cereales = "Cereales permitidos en '" + lote.getIdentificador() + "': ";
        for (Cereal cereal : this.cereales) {
            if (cereal.sePuedeSembrarEn(lote))
                cereales += cereal.getNombre() + " ";
        }
        return cereales;
    }

    public String getLotesParaCereal(Cereal cereal) {
        String lotes = "Lotes en donde se puede sembrar " + cereal.getNombre() + ": ";
        for (Lote lote : this.lotes) {
            if (lote.sePuedeSembrar(cereal))
                lotes += "'" + lote.getIdentificador() + "' ";
        }
        return lotes;
    }

    public void agregarMineralPrimario(String mineral) {
        if (!this.mineralesPrimarios.contains(mineral))
            this.mineralesPrimarios.add(mineral);
    }

    public void eliminarMineralPrimario(String mineral) {
        this.mineralesPrimarios.remove(mineral);
    }

    public boolean esEspecial(Lote lote) {
        for (String mineralPrimario : this.mineralesPrimarios) {
            if (!lote.tieneMineral(mineralPrimario))
                return false;
        }
        return true;
    }
}
