package tp10.e04.condiciones;

import tp10.e04.Gasto;

public abstract class Condicion<T> {
    public abstract boolean esCumplidaPor(Gasto<T> gasto);
}
