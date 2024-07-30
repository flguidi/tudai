package tp07.e01.condiciones;

import tp07.e01.Agroquimico;
import tp07.e01.Cultivo;

public class CondicionCultivo extends Condicion {
    // Atributos
    Cultivo cultivo;

    // Constructores
    public CondicionCultivo(Cultivo cultivo) {
        this.cultivo = cultivo;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(Agroquimico agroquimico) {
        return agroquimico.puedeUtilizarseEn(cultivo);
    }
}
