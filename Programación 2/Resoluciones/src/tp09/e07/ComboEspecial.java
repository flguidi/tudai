package tp09.e07;

public class ComboEspecial extends Combo {
    // Constructores
    public ComboEspecial(String nombre, double descuento, double topeDescuento) {
        super(nombre, descuento, topeDescuento);
    }

    // Métodos
    @Override
    public double getPrecio() {
        double precioMayor = 0;
        for (ElementoBazar e : this.elementos) {
            double precioParcial = e.getPrecio();
            if (precioParcial > precioMayor)
                precioMayor = precioParcial;
        }
        return precioMayor;
    }
}
