package encapsulationweek7.assignment_problems;

import java.util.Arrays;

class Playlist {
    private final String[] songs;
    private int size;

    Playlist(int capacity) {
        songs = new String[Math.max(0, capacity)];
    }

    public void addSong(String song) {
        if (song != null && size < songs.length) songs[size++] = song;
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, size);
    }
}

public class Week7_Encapsulation_Playlist {
    public static void main(String[] args) {
        Playlist playlist = new Playlist(5);
        playlist.addSong("Song A");
        playlist.addSong("Song B");
        String[] copy = playlist.getSongs();
        copy[0] = "Changed outside";
        System.out.println(Arrays.toString(playlist.getSongs()));
    }
}
