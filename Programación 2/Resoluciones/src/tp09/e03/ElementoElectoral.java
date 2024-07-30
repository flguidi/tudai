package tp09.e03;

import tp09.e03.condiciones.Condicion;

public abstract class ElementoElectoral {
    public abstract int contarVotos();
    public abstract int filtrar(Condicion condicion);
}
