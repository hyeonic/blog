package me.hyeonic.object.chapter10.playlist.step02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 가수별 노래의 제목도 관리하는 요구사항 추가
// 클래스를 상속하면 결합도로 인해 자식 클래스와 부모 클래스의 구현을 영원히 변경하지 않거나, 동시에 변경해야 한다.
public class Playlist {
    private List<Song> tracks;
    private Map<String, String> singers;

    public Playlist() {
        this.tracks = new ArrayList<>();
        this.singers = new HashMap<>();
    }

    public void append(Song song) {
        getTracks().add(song);
        singers.put(song.getSinger(), song.getTitle()); // 동시에 변경하는 부분
    }

    public List<Song> getTracks() {
        return tracks;
    }

    public Map<String, String> getSingers() {
        return singers;
    }
}