package me.hyeonic.object.chapter10.playlist.step02;

public class PersonalPlaylist extends Playlist {
    public void remove(Song song) {
        getTracks().remove(song);
        getSingers().remove(song.getSinger()); // 동시에 변경하는 부분
    }
}