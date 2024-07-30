package tp09.e03.condiciones;

import tp09.e03.Voto;

public class CondicionCandidato extends Condicion {
    // Atributos
    private String nombreCandidato;

    // Constructores
    public CondicionCandidato(String nombreCandidato) {
        this.nombreCandidato = nombreCandidato;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Voto voto) {
        if (voto.getCandidato() != null)
            return voto.getCandidato().getNombre().equals(nombreCandidato);
        else
            return false;
    }
}
