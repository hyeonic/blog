package me.hyeonic.playlist.dto.social;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.hyeonic.playlist.dto.nonplaylist.Provider;

import java.util.List;

@Getter
@NoArgsConstructor
public class TracksMainDto {

    private Provider provider;
    private List<Track> tracks;

    @Getter
    @NoArgsConstructor
    public static class Track {
        private String id;
        private String name;
        private List<Image> images;
        private List<String> artists;
        private String previewUrl;

        @Getter
        @NoArgsConstructor
        public static class Image {
            private String height;
            private String url;
            private String width;

            @Builder
            public Image(String height, String url, String width) {
                this.height = height;
                this.url = url;
                this.width = width;
            }
        }

        @Builder
        public Track(String id, String name, List<Image> images, List<String> artists, String previewUrl) {
            this.id = id;
            this.name = name;
            this.images = images;
            this.artists = artists;
            this.previewUrl = previewUrl;
        }
    }

    @Builder
    public TracksMainDto(Provider provider, List<Track> tracks) {
        this.provider = provider;
        this.tracks = tracks;
    }
}