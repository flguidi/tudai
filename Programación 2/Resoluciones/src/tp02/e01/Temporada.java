package tp02.e01;

public class Temporada {
    // Atributos
    private Episodio[] episodios;
    private int cantidadEpisodios;

    // Constructores
    public Temporada(int limiteEpisodios) {
        this.episodios = new Episodio[limiteEpisodios];
        this.cantidadEpisodios = 0;
    }

    // Métodos
    public Episodio getEpisodio(int numeroEpisodio) {
        return episodios[numeroEpisodio - 1];
    }

    public void agregarEpisodio(Episodio episodio) {
        if (this.cantidadEpisodios >= this.episodios.length) {
            Episodio[] episodiosAux = new Episodio[this.episodios.length * 2];
            for (int i = 0; i < this.cantidadEpisodios; i++)
                episodiosAux[i] = this.episodios[i];
            this.episodios = episodiosAux;
        }

        this.episodios[this.cantidadEpisodios] = episodio;
        this.cantidadEpisodios++;
    }

    public void eliminarEpisodio() {
        if (this.cantidadEpisodios > 0) {
            this.episodios[cantidadEpisodios - 1] = null;
            this.cantidadEpisodios--;

            if (this.cantidadEpisodios <= this.episodios.length / 2) {
                Episodio[] episodiosAux = new Episodio[this.cantidadEpisodios];
                for (int i = 0; i < this.cantidadEpisodios; i++)
                    episodiosAux[i] = this.episodios[i];
                this.episodios = episodiosAux;
            }
        }
    }

    public int getCantEpisodiosVistos() {
        int cantEpisodiosVistos = 0;

        for (int i = 0; i < this.cantidadEpisodios; i++) {
            if (this.episodios[i].seVio())
                cantEpisodiosVistos++;
        }

        return cantEpisodiosVistos;
    }

    public boolean seVio() {
        boolean seVio = true;
        int i = 0;

        while (i < this.cantidadEpisodios && seVio) {
            seVio = this.episodios[i].seVio();
            i++;
        }

        return seVio;
    }

    public double getPromedioCalificaciones() {
        int calificacionTotal = 0;
        int cantVistos = 0;

        for (int i = 0; i < this.cantidadEpisodios; i++) {
            if (this.episodios[i].seVio()) {
                calificacionTotal += this.episodios[i].getCalificacion();
                cantVistos++;
            }
        }

        if (cantVistos > 0)
            return (double) calificacionTotal / cantVistos;

        return 0;
    }
}
