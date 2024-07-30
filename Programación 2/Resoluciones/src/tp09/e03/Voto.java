package tp09.e03;

import tp09.e03.condiciones.Condicion;
import java.time.LocalDateTime;

public class Voto extends ElementoElectoral {
    // Atributos
    private int dniVotante;
    private Candidato candidato; // null si es voto en blanco
    private LocalDateTime fecha;

    // Constructores
    public Voto(int dniVotante, Candidato candidato) {
        this.dniVotante = dniVotante;
        this.candidato = candidato;
        this.fecha = LocalDateTime.now();
    }

    // Métodos
    public int getDniVotante() {
        return dniVotante;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    @Override
    public int contarVotos() {
        return 1;
    }

    @Override
    public int filtrar(Condicion condicion) {
        if (condicion.esCumplidaPor(this))
            return 1;
        else
            return 0;
    }

    @Override
    public boolean equals(Object o) {
        try {
            Voto otro = (Voto) o;
            return this.getDniVotante() == otro.getDniVotante();
        } catch (Exception e) {
            return false;
        }
    }
}
