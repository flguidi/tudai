package tp05.e06;

public class Poster extends Trabajo {
    // Constructores
    public Poster(String titulo, String tipo) {
        super(titulo, "Póster");
    }

    // Métodos
    @Override
    public boolean puedeSerEvaluadoPor(Evaluador evaluador) {
        for (String palabraClave : this.palabrasClaves) {
            if (evaluador.tieneConocimiento(palabraClave))
                return true;
        }
        return false;
    }
}
