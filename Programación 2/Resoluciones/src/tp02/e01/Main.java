package tp02.e01;

public class Main {
    public static void main(String[] args) {
        // Se crea una serie
        Serie serie = new Serie("Serie 1","Descripción de la serie" ,"Creador" ,"Género",10);

        // Se agrega una temporada a la serie
        serie.agregarTemporada(new Temporada(20));

        // Se agregan tres episodios a la primera temporada
        serie.getTemporada(1).agregarEpisodio(new Episodio("Capítulo 1", "Descripción 1"));
        serie.getTemporada(1).agregarEpisodio(new Episodio("Capítulo 2", "Descripción 2"));
        serie.getTemporada(1).agregarEpisodio(new Episodio("Capítulo 3", "Descripción 3"));

        // Se califican los episodios y se calcula el promedio de calificaciones
        serie.getTemporada(1).getEpisodio(1).setCalificacion(5);
        serie.getTemporada(1).getEpisodio(2).setCalificacion(3);
        serie.getTemporada(1).getEpisodio(3).setCalificacion(2);
        double promedioTemporada = serie.getTemporada(1).getPromedioCalificaciones();
        double promedioSerie = serie.getPromedioCalificaciones();
        System.out.println("Promedio de calificaciones de la temporada 1: " + promedioTemporada);
        System.out.println("Promedio de calificaciones de la serie: " + promedioSerie);

        // Se elimina el ùltimo episodio de la primera temporada
        serie.getTemporada(1).eliminarEpisodio();

        // Se obtiene la cantidad de episodios vistos (en la serie y en la temporada 1) y se muestra en consola
        int cantVistosTemporada = serie.getTemporada(1).getCantEpisodiosVistos();
        int cantVistosSerie = serie.getCantEpisodiosVistos();
        System.out.println("Cantidad de capítulos vistos en la temporada 1: " + cantVistosTemporada);
        System.out.println("Cantidad de capítulos vistos en la serie: " + cantVistosSerie);

        // Se verifica si se vio el primer episodio, la priemra temporada y la serie completa
        boolean episodioVisto = serie.getTemporada(1).getEpisodio(1).seVio();
        boolean temporadaVista = serie.getTemporada(1).seVio();
        boolean serieVista = serie.seVio();
        System.out.println("Se vio el primer episodio de la serie: " + episodioVisto);
        System.out.println("Se vio la primera temporada: " + temporadaVista);
        System.out.println("Se vio la serie: " + serieVista);
    }
}
