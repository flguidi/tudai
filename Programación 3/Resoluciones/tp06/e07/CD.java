package tp06.e07;

import java.util.ArrayList;
import java.util.List;

public class CD {

    private int capacityInKB;
    private final List<Song> songs;

    public CD(int capacityInKB) {
        this.capacityInKB = capacityInKB;
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        if (!songs.contains(song) && song.getSizeInKB() <= capacityInKB) {
            songs.add(song);
            capacityInKB -= song.getSizeInKB();
        }
    }

    public List<Song> getSongs() {
        return new ArrayList<>(songs);
    }

}
