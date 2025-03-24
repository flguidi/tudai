package tp06.e07;

import java.util.Comparator;

public class Song {

    private final String name;
    private final String genre;
    private final int durationInSeconds;
    private final int sizeInKB;

    public Song(String name, String genre, int durationInSeconds, int sizeInKB) {
        this.name = name;
        this.genre = genre;
        this.durationInSeconds = durationInSeconds;
        this.sizeInKB = sizeInKB;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public int getDurationInSeconds() {
        return durationInSeconds;
    }

    public int getSizeInKB() {
        return sizeInKB;
    }

    @Override
    public String toString() {
        return name + " (" + genre + ", " + durationInSeconds + "s, " + sizeInKB + "kb)";
    }

    // Comparador por duración en segundos
    public static class DurationComparator implements Comparator<Song> {
        @Override
        public int compare(Song s1, Song s2) {
            return Integer.compare(s1.getDurationInSeconds(), s2.getDurationInSeconds());
        }
    }

    // Comparador por tamaño en kilobytes
    public static class SizeComparator implements Comparator<Song> {
        @Override
        public int compare(Song s1, Song s2) {
            return Integer.compare(s1.getSizeInKB(), s2.getSizeInKB());
        }
    }

}
