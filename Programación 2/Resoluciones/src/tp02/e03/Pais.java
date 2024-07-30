package tp02.e03;

public class Pais {
    // Atributos
    private String nombre;
    private Provincia[] provincias;
    private int cantidadProvincias;

    // Constructores
    public Pais(String nombre, int limiteProvincias) {
        this.nombre = nombre;
        this.provincias = new Provincia[limiteProvincias];
        this.cantidadProvincias = 0;
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Provincia getProvincia(int numeroProvincia) {
        if (numeroProvincia > 0 && numeroProvincia < this.provincias.length)
            return provincias[numeroProvincia - 1];

        return null;
    }

    public void agregarProvincia(Provincia provincia) {
        if (cantidadProvincias >= this.provincias.length) {
            Provincia[] provinciasAux = new Provincia[this.provincias.length * 2];
            for (int i = 0; i < this.cantidadProvincias; i++)
                provinciasAux[i] = this.provincias[i];
            this.provincias = provinciasAux;
        }

        this.provincias[this.cantidadProvincias] = provincia;
        this.cantidadProvincias++;
    }

    public void eliminarProvincia() {
        if (this.cantidadProvincias > 0) {
            this.provincias[this.cantidadProvincias - 1] = null;
            this.cantidadProvincias--;

            if (this.cantidadProvincias <= this.provincias.length / 2) {
                Provincia[] provinciasAux = new Provincia[this.cantidadProvincias];
                for (int i = 0; i < this.cantidadProvincias; i++)
                    provinciasAux[i] = provincias[i];
                this.provincias = provinciasAux;
            }
        }
    }
}
