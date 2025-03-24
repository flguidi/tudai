package tp06.e07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Armando CDs:
 * Dado un conjunto de archivos de canciones, donde cada uno tiene la información de nombre, género,
 * duración del tema, y tamaño en kilobytes, se desea grabar un disco CD (que tiene una capacidad
 * máxima de M kilobytes) de modo tal de:
 * a) Maximizar la capacidad ocupada del disco CD;
 * b) Maximizar la cantidad de canciones que se pueden grabar en el CD.
 * Para ambas variantes se quiere, además, que el CD no contenga más de 3 canciones de un mismo
 * género.
 */
public class CDBuilder {

    private final int maxSongsPerGenre; // Cantidad máxima de canciones por género

    public CDBuilder(int maxSongsPerGenre) {
        this.maxSongsPerGenre = maxSongsPerGenre;
    }

    /**
     * Construye un CD maximizando la capacidad ocupada, respetando la restricción de máximo número de
     * canciones por género.
     *
     * @param availableSongs Lista de canciones disponibles para agregar al CD.
     * @param maxCapacity    Capacidad máxima del CD en kilobytes.
     * @return CD construido con las canciones seleccionadas para maximizar la capacidad ocupada.
     */
    public CD buildMaxCapacityCD(List<Song> availableSongs, int maxCapacity) {
        // Se ordenan las canciones por tamaño descendente
        List<Song> songsCopy = new ArrayList<>(availableSongs);
        songsCopy.sort(new Song.SizeComparator().reversed());

        return buildCD(songsCopy, maxCapacity);
    }

    /**
     * Construye un CD maximizando la cantidad de canciones grabadas, respetando la restricción de máximo
     * número de canciones por género.
     *
     * @param availableSongs Lista de canciones disponibles para agregar al CD.
     * @param maxCapacity    Capacidad máxima del CD en kilobytes.
     * @return CD construido con las canciones seleccionadas para maximizar la cantidad de canciones.
     */
    public CD buildMaxSongsCD(List<Song> availableSongs, int maxCapacity) {
        // Se ordenan las canciones por duración ascendente
        List<Song> songsCopy = new ArrayList<>(availableSongs);
        songsCopy.sort(new Song.DurationComparator());

        return buildCD(songsCopy, maxCapacity);
    }

    /**
     * Construye un CD a partir de una lista de canciones ordenadas, respetando la capacidad máxima
     * del CD y la restricción de máximo número de canciones por género.
     *
     * @param songs       Lista de canciones ya ordenadas que se utilizarán para llenar el CD.
     * @param maxCapacity Capacidad máxima del CD en kilobytes.
     * @return CD construido con las canciones seleccionadas.
     */
    private CD buildCD(List<Song> songs, int maxCapacity) {
        CD cd = new CD(maxCapacity);
        Map<String, Integer> genreCount = new HashMap<>();
        int remainingCapacity = maxCapacity;

        while (!songs.isEmpty()) {
            Song song = songs.removeFirst();
            String genre = song.getGenre();

            if (song.getSizeInKB() <= remainingCapacity && genreCount.getOrDefault(genre, 0) < maxSongsPerGenre) {
                cd.addSong(song);
                genreCount.put(genre, genreCount.getOrDefault(genre, 0) + 1);
                remainingCapacity -= song.getSizeInKB();
            }
        }

        return cd;
    }

}
