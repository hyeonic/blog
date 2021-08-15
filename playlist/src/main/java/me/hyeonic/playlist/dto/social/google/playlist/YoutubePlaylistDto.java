package me.hyeonic.playlist.dto.social.google.playlist;

import lombok.Getter;
import me.hyeonic.playlist.dto.nonplaylist.NonPlaylistDto;
import me.hyeonic.playlist.dto.nonplaylist.Provider;
import me.hyeonic.playlist.dto.social.TracksMainDto;

import java.util.ArrayList;
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

            @Getter
            private static class Status {
                private String privacyStatus;
            }
        }

        public NonPlaylistDto.PlayLists toNonPlaylists() {

            List<NonPlaylistDto.PlayLists.Playlist> nonPlaylists = new ArrayList<>();

            for (Item item : items) {

                if (item.getStatus().privacyStatus.equals("private")) {
                    continue;
                }

                Item.Snippet.Thumbnail thumbnail = item.getSnippet().getThumbnails().get("default");
                NonPlaylistDto.PlayLists.Playlist.Image image = NonPlaylistDto.PlayLists.Playlist.Image.builder()
                        .url(thumbnail.getUrl())
                        .width(thumbnail.getWidth())
                        .height(thumbnail.getHeight()).build();

                NonPlaylistDto.PlayLists.Playlist nonPlaylist = NonPlaylistDto.PlayLists.Playlist.builder()
                        .originalId(item.getId())
                        .originalTitle(item.getSnippet().getTitle())
                        .originalDescription(item.getSnippet().getDescription())
                        .image(image)
                        .externalUrl("https://music.youtube.com/playlist?list=" + item.getId())
                        .build();

                nonPlaylists.add(nonPlaylist);
            }

            return NonPlaylistDto.PlayLists.builder()
                    .provider(Provider.YOUTUBE)
                    .playlists(nonPlaylists)
                    .build();
        }
    }

    @Getter
    public static class Playlist {
        private String kind;
        private String etag;
        private List<Item> items;

        @Getter
        private static class Item {
            private String kind;
            private String etag;
            private String id;
            private Snippet snippet;
            private ContentDetails contentDetails;
            private Status status;

            @Getter
            private static class Snippet {
                private String publishedAt;
                private String channelId;
                private String title;
                private String description;
                private Map<String, Thumbnail> thumbnails;
                private String channelTitle;
                private String playlistId;
                private String position;
                private ResourceId resourceId;
                private String videoOwnerChannelTitle;
                private String videoOwnerChannelId;

                @Getter
                private static class Thumbnail {
                    private String url;
                    private String width;
                    private String height;
                }

                @Getter
                private static class ResourceId {
                    private String kind;
                    private String videoId;
                }
            }

            @Getter
            private static class ContentDetails {
                private String videoId;
                private String videoPublishedAt;
            }

            @Getter
            private static class Status {
                private String privacyStatus;
            }
        }

        public TracksMainDto toTracks() {

            List<TracksMainDto.Track> tracks = new ArrayList<>();
            for (Item item : items) {

                List<TracksMainDto.Track.Image> images = new ArrayList<>();
                for (String key : item.getSnippet().getThumbnails().keySet()) {
                    Item.Snippet.Thumbnail thumbnail = item.getSnippet().getThumbnails().get(key);
                    TracksMainDto.Track.Image image = TracksMainDto.Track.Image.builder()
                            .url(thumbnail.getUrl())
                            .width(thumbnail.getWidth())
                            .height(thumbnail.getHeight())
                            .build();

                    images.add(image);
                }

                List<String> artists = new ArrayList<>();
                artists.add(item.getSnippet().getVideoOwnerChannelTitle());

                TracksMainDto.Track track = TracksMainDto.Track.builder()
                        .id(item.getId())
                        .name(item.getSnippet().getTitle())
                        .images(images)
                        .artists(artists)
                        .previewUrl(null)
                        .build();

                tracks.add(track);
            }

            return TracksMainDto.builder()
                    .provider(Provider.YOUTUBE)
                    .tracks(tracks)
                    .build();
        }
    }
}