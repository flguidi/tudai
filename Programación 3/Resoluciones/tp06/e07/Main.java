package tp06.e07;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Canciones de ejemplo
        List<Song> songs = new ArrayList<>();
        songs.add(new Song("Canción 1", "Pop", 240, 400));
        songs.add(new Song("Canción 2", "Rock", 180, 300));
        songs.add(new Song("Canción 3", "Jazz", 210, 350));
        songs.add(new Song("Canción 4", "Pop", 250, 450));
        songs.add(new Song("Canción 5", "Jazz", 200, 300));
        songs.add(new Song("Canción 6", "Jazz", 165, 250));
        songs.add(new Song("Canción 7", "Pop", 220, 380));
        songs.add(new Song("Canción 8", "Rock", 210, 330));
        songs.add(new Song("Canción 9", "Jazz", 170, 300));


        // Capacidad máxima del CD en KB
        int maxCapacity = 1500;
        System.out.println("Capacidad máxima del CD: " + maxCapacity + "kb");

        // Cantidad máxima de canciones por género
        int maxSongsPerGenre = 3;
        System.out.println("Cantidad máxima de canciones por género: " + maxSongsPerGenre);

        // Problema del constructor de CDs
        CDBuilder cdBuilder = new CDBuilder(maxSongsPerGenre);

        // Variante A: Maximizar la capacidad ocupada del CD
        CD maxCapacityCD = cdBuilder.buildMaxCapacityCD(songs, maxCapacity);

        System.out.println("\nCD con capacidad máxima ocupada:");
        for (Song song : maxCapacityCD.getSongs()) {
            System.out.println(song);
        }

        // Variante B: Maximizar la cantidad de canciones que se pueden grabar
        CD maxSongsCD = cdBuilder.buildMaxSongsCD(songs, maxCapacity);

        System.out.println("\nCD con máximo número de canciones:");
        for (Song song : maxSongsCD.getSongs()) {
            System.out.println(song);
        }
    }

}
