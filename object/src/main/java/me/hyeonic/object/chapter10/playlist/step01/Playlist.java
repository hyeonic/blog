package me.hyeonic.object.chapter10.playlist.step01;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private List<Song> tracks;

    public Playlist() {
        this.tracks = new ArrayList<>();
    }

    public void append(Song song) {
        getTracks().add(song);
    }

    public List<Song> getTracks() {
        return tracks;
    }
}