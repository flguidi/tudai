package tp02.e01;

public class Serie {
    // Atributos
    private String titulo;
    private String descripcion;
    private String creador;
    private String genero;
    private Temporada[] temporadas;
    private int cantidadTemporadas;

    // Constructores
    public Serie(String titulo, String descripcion, String creador, String genero, int limiteTemporadas) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.creador = creador;
        this.genero = genero;
        this.temporadas = new Temporada[limiteTemporadas];
        this.cantidadTemporadas = 0;
    }

    // Métodos
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Temporada getTemporada(int numeroTemporada) {
        return temporadas[numeroTemporada - 1];
    }

    public void agregarTemporada(Temporada temporada) {
        if (this.cantidadTemporadas >= this.temporadas.length) {
            Temporada[] temporadasAux = new Temporada[this.temporadas.length * 2];
            for (int i = 0; i < this.cantidadTemporadas; i++)
                temporadasAux[i] = this.temporadas[i];
            this.temporadas = temporadasAux;
        }

        this.temporadas[this.cantidadTemporadas] = temporada;
        this.cantidadTemporadas++;
    }

    public void eliminarTemporada() {
        if (this.cantidadTemporadas > 0) {
            this.temporadas[this.cantidadTemporadas - 1] = null;
            cantidadTemporadas--;

            if (this.cantidadTemporadas <= this.temporadas.length / 2) {
                Temporada[] temporadasAux = new Temporada[this.cantidadTemporadas];
                for (int i = 0; i < this.cantidadTemporadas; i++)
                    temporadasAux[i] = this.temporadas[i];
                this.temporadas = temporadasAux;
            }
        }
    }

    public int getCantidadTemporadas() {
        return cantidadTemporadas;
    }

    public int getCantEpisodiosVistos() {
        int cantEpisodiosVistos = 0;
        for (int i = 0; i < this.cantidadTemporadas; i++)
            cantEpisodiosVistos += this.temporadas[i].getCantEpisodiosVistos();
        return cantEpisodiosVistos;
    }

    public boolean seVio() {
        boolean seVio = true;

        int i = 0;
        while (i < this.cantidadTemporadas && seVio) {
            seVio = this.temporadas[i].seVio();
            i++;
        }

        return seVio;
    }

    public double getPromedioCalificaciones() {
        if (cantidadTemporadas > 0) {
            double calificacionTotal = 0;
            for (int i = 0; i < this.cantidadTemporadas; i++)
                calificacionTotal += temporadas[i].getPromedioCalificaciones();
            return calificacionTotal / cantidadTemporadas;
        } else {
            return 0;
        }
    }
}

