package tp05.e03;

public class Pastura extends Cereal {
    // Atributos
    private int minimoHectareas;

    // Constructores
    public Pastura(String nombre, String tipo, int minimoHectareas) {
        super(nombre, "Pastura");
        this.minimoHectareas = minimoHectareas;
    }

    // Métodos
    @Override
    public boolean sePuedeSembrarEn(Lote lote) {
        return super.sePuedeSembrarEn(lote) && lote.getHectareas() >= this.minimoHectareas;
    }
}
