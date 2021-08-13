package me.hyeonic.playlist.dto.social.google.playlist;

import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
public class YoutubePlaylistDto {

    @Getter
    public static class Playlists {
        private String kind;
        private String etag;
        private PageInfo pageInfo;
        private List<Item> items;

        @Getter
        private static class PageInfo {
            private String totalResults;
            private String resultsPerPage;
        }

        @Getter
        private static class Item {
            private String kind;
            private String etag;
            private String id;
            private Snippet snippet;
            private Status status;

            @Getter
            private static class Snippet {
                private String publishedAt;
                private String channelId;
                private String title;
                private String description;
                private Map<String, Thumbnail> thumbnails;
                private String channelTitle;

                @Getter
                private static class Thumbnail {
                    private String url;
                    private String width;
                    private String height;
                }
            }
        }

        @Getter
        private static class Status {
            private String privacyStatus;
        }
    }
}