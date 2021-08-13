package me.hyeonic.playlist.dto.social.spotify.playlist;

import lombok.Getter;

import java.util.List;

@Getter
public class SpotifyPlaylistDto {

    @Getter
    public static class Playlists {
        private String href;
        private List<Item> items;
        private String limit;
        private String next;
        private String offset;
        private String previous;
        private String total;

        @Getter
        private static class Item {
            private boolean collaborative;
            private String description;
            private ExternalUrls external_urls;
            private String href;
            private String id;
//            private List<Image> images;
            private String name;
            private Owner owner;
            private String primary_color;
            private String snapshot_id;
            private boolean pub;
            private Tracks tracks;
            private String type;
            private String uri;

            @Getter
            private static class ExternalUrls {
                private String spotify;
            }

            @Getter
            private static class Image {
            }

            @Getter
            private static class Owner {
                private String display_name;
                private ExternalUrls external_urls;
                private String href;
                private String id;
                private String type;
                private String uri;

                @Getter
                private static class ExternalUrls {
                    private String spotify;
                }
            }

            @Getter
            private static class Tracks {
                private String href;
                private String total;
            }
        }
    }
}