package tp06.e04;

public class Sistema {
    // Atributos
    private ColaElementos colaElementos1;
    private ColaElementos colaElementos2;

    // Constructores
    public Sistema() {
        this.colaElementos1 = new ColaElementos();
        this.colaElementos2 = new ColaElementos();
    }

    // Métodos
    public void procesarColaElementos1(Elemento elemento1) {
        if (colaElementos2.tieneElementos()) {
            Elemento elemento2 = (Elemento) colaElementos2.obtenerSiguiente();
            // Procesar 'elemento2', obtenido de 'colaEspera2
        } else {
            // Agregar 'elemento1' a 'colaEspera1', según critero de ordenamiento dado
            colaElementos1.agregarElemento(elemento1);
        }
    }

    public void procesarColaElementos2(Elemento elemento2) {
        if (colaElementos1.tieneElementos()) {
            Elemento elemento1 = (Elemento) colaElementos1.obtenerSiguiente();
            // Procesar 'elemento1', obtenido de 'colaEspera1'
        } else {
            // Agregar 'elemento2' a 'colaEspera2', según critero de ordenamiento dado
            colaElementos2.agregarElemento(elemento2);
        }
    }

    // Más métodos...
}
