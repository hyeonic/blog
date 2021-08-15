package me.hyeonic.playlist.dto.nonplaylist;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
public class NonPlaylistDto {

    @Getter
    @NoArgsConstructor
    public static class PlayLists {
        private Provider provider;
        private List<Playlist> playlists;

        @Builder
        public PlayLists(Provider provider, List<Playlist> playlists) {
            this.provider = provider;
            this.playlists = playlists;
        }

        @Getter
        @NoArgsConstructor
        public static class Playlist {
            private String originalId;
            private String originalTitle;
            private String originalDescription;
            private Image image;
            private String externalUrl;

            @Builder
            public Playlist(String originalId, String originalTitle, String originalDescription,
                            Image image, String externalUrl) {
                this.originalId = originalId;
                this.originalTitle = originalTitle;
                this.originalDescription = originalDescription;
                this.image = image;
                this.externalUrl = externalUrl;
            }

            @Getter
            @NoArgsConstructor
            public static class Image {
                private String url;
                private String width;
                private String height;

                @Builder
                public Image(String url, String width, String height) {
                    this.url = url;
                    this.width = width;
                    this.height = height;
                }
            }
        }
    }
}