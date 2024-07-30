package tp10.e05.condiciones;

import tp10.e05.ElementoDeCarga;

public class CondicionDestino extends Condicion {
    // Atributos
    private String destino;

    // Constructores
    public CondicionDestino(String destino) {
        this.destino = destino;
    }

    // Métodos
    @Override
    public boolean esCumplidaPor(ElementoDeCarga paquete) {
        return paquete.getDestino().equalsIgnoreCase(this.destino);
    }
}
