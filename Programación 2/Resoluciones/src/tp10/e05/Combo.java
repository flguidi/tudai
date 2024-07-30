package tp10.e05;

import tp10.e05.condiciones.Condicion;
import java.time.LocalDate;
import java.util.ArrayList;

public class Combo extends ElementoDeCarga {
    // Atributos
    protected ArrayList<ElementoDeCarga> elementos;

    // Constructores
    public Combo(String id, String destino, LocalDate fechaPartida) {
        super(id, destino, fechaPartida);
        this.elementos = new ArrayList<>();
    }

    // Métodos
    public void agregarElemento(ElementoDeCarga elemento) {
        if (puedeAgregarse(elemento))
            this.elementos.add(elemento);
    }

    private boolean puedeAgregarse(ElementoDeCarga elemento) {
        return !this.elementos.contains(elemento)
                && elemento.getDestino().equalsIgnoreCase(this.getDestino())
                && elemento.getFechaPartida().equals(this.getFechaPartida());
    }

    public void eliminarElemento(ElementoDeCarga elemento) {
        this.elementos.remove(elemento);
    }

    @Override
    public double getCostoEnvio() {
        double total = 0;
        for (ElementoDeCarga e : this.elementos)
            total += e.getCostoEnvio();
        return total;
    }

    @Override
    public double getValorAsegurado() {
        double total = 0;
        for (ElementoDeCarga e : this.elementos)
            total += e.getValorAsegurado();
        return total;
    }

    public ElementoDeCarga getPaqueteMayorValorAsegurado() {
        ElementoDeCarga paqueteMayorValor = null;
        double mayorValor = 0;

        for (ElementoDeCarga e : this.elementos) {
            if (e.getValorAsegurado() > mayorValor) {
                mayorValor = e.getValorAsegurado();
                paqueteMayorValor = e;
            }
        }

        return paqueteMayorValor;
    }

    @Override
    public int cantidad() {
        int cantidad = 0;
        for (ElementoDeCarga e : this.elementos)
            cantidad += e.cantidad();
        return cantidad;
    }

    @Override
    public ArrayList<ElementoDeCarga> buscar(Condicion condicion) {
        ArrayList<ElementoDeCarga> busqueda = new ArrayList<>();

        // Si cumple con la condición, se incluye el combo actual
        if (condicion.esCumplidaPor(this))
            busqueda.add(this);

        // Se propaga la búsqueda en cada componente
        for (ElementoDeCarga e : this.elementos)
            busqueda.addAll(e.buscar(condicion));

        return busqueda;
    }

    @Override
    public ElementoDeCarga copiar() {
        Combo copia = this.copiarCombo(this);
        for (ElementoDeCarga e : this.elementos)
            copia.agregarElemento(e.copiar());
        return copia;
    }

    private Combo copiarCombo(Combo c) {
        return new Combo(c.getId(), c.getDestino(), c.getFechaPartida());
    }

    @Override
    public String listar(int nivelIndentacion) {
        String indentacion = "";
        for (int i = 0; i < nivelIndentacion; i++)
            indentacion += "\t";

        String lista = indentacion +
                "Combo " + this.getId() + " (" +
                this.getDestino() + ", " +
                this.getFechaPartida() + ", " +
                "e: $" + this.getCostoEnvio() + ", " +
                "v: $" + this.getValorAsegurado() + ")\n";

        for (ElementoDeCarga e : this.elementos)
            lista += e.listar(nivelIndentacion + 1) + "\n";

        return lista;
    }
}
