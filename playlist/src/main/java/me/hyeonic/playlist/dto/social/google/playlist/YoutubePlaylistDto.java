package me.hyeonic.playlist.dto.social.google.playlist;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

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
//                private List<Thumbnails> thumbnails;
                private String channelTitle;

                @Getter
                private static class Thumbnails {
                }
            }

            @Getter
            private static class Status {
                private String privacyStatus;
            }
        }
    }
}