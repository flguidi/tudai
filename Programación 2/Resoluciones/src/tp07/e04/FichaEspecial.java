package tp07.e04;

public class FichaEspecial extends Ficha {
    // Constructores
    public FichaEspecial(String nombre, double fortaleza, int espacio) {
        super(nombre, fortaleza, espacio, 0);
        double poder = getPoderDestruccion(); // Se calcula el poder de destrucción
        super.setPoderDestruccion(poder);
    }

    // Métodos
    @Override
    public double getPoderDestruccion() { // Sobreescritura de método heredado
        if (super.getEspacio() == 0)
            return 0;
        else
            return super.getFortaleza() / super.getEspacio();
    }
}
