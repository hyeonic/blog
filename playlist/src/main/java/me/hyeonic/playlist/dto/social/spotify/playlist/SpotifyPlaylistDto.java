package me.hyeonic.playlist.dto.social.spotify.playlist;

import lombok.Getter;
import me.hyeonic.playlist.dto.nonplaylist.NonPlaylistDto;
import me.hyeonic.playlist.dto.nonplaylist.Provider;
import me.hyeonic.playlist.dto.social.TracksMainDto;

import java.util.ArrayList;
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
            private List<Image> images;
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
                private String height;
                private String url;
                private String width;
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

        public NonPlaylistDto.PlayLists toNonPlaylists() {

            List<NonPlaylistDto.PlayLists.Playlist> nonPlaylists = new ArrayList<>();

            for (Item item : items) {

                Item.Image originalImage = item.images.get(0);
                NonPlaylistDto.PlayLists.Playlist.Image image = NonPlaylistDto.PlayLists.Playlist.Image
                        .builder()
                        .url(originalImage.getUrl())
                        .width(originalImage.getWidth())
                        .height(originalImage.getHeight())
                        .build();

                NonPlaylistDto.PlayLists.Playlist nonPlaylist = NonPlaylistDto.PlayLists.Playlist.builder()
                        .originalId(item.getId())
                        .originalTitle(item.getName())
                        .originalDescription(item.getDescription())
                        .image(image)
                        .externalUrl(item.getHref())
                        .build();

                nonPlaylists.add(nonPlaylist);
            }

            return NonPlaylistDto.PlayLists.builder()
                    .provider(Provider.SPOTIFY)
                    .playlists(nonPlaylists)
                    .build();
        }
    }

    @Getter
    public static class Playlist {
        private boolean collaborate;
        private String description;
        private ExternalUrls external_urls;
        private Followers followers;
        private String href;
        private String id;
        private List<Image> images;
        private String name;
        private Owner owner;
        private String primary_color;
        private boolean pub;
        private String snapshot_id;
        private Tracks tracks;

        @Getter
        private static class ExternalUrls {
            private String spotify;
        }

        @Getter
        private static class Followers {
            private String href;
            private String total;
        }

        @Getter
        private static class Image {
            private String height;
            private String url;
            private String width;
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
            private List<Item> items;

            @Getter
            private static class Item {
                private String added_at;
                private boolean is_local;
                private String primary_color;
                private Track track;
                private VideoThumbnail video_thumbnail;

                @Getter
                private static class Track {
                    private Album album;
                    private List<Artist> artists;
                    private String disc_number;
                    private String duration_ms;
                    private boolean episode;
                    private boolean explicit;
                    private ExternalIds external_ids;
                    private ExternalUrls external_urls;
                    private String href;
                    private String id;
                    private boolean is_local;
                    private boolean is_playable;
                    private String name;
                    private String popularity;
                    private String preview_url;
                    private boolean track;
                    private String track_number;
                    private String type;
                    private String uri;

                    @Getter
                    private static class Album {
                        private String album_type;
                        private List<Artist> artists;
                        private ExternalUrls external_urls;
                        private String href;
                        private String id;
                        private List<Image> images;
                        private String name;
                        private String release_date;
                        private String release_date_precision;
                        private String total_tracks;
                        private String type;
                        private String uri;

                        @Getter
                        private static class Artist {
                            private ExternalUrls external_urls;
                            private String href;
                            private String id;
                            private String name;
                            private String type;
                            private String uri;

                            @Getter
                            private static class ExternalUrls {
                                private String spotify;
                            }
                        }

                        @Getter
                        private static class ExternalUrls {
                            private String spotify;
                        }

                        @Getter
                        private static class Image {
                            private String height;
                            private String url;
                            private String width;
                        }
                    }

                    @Getter
                    private static class Artist {
                        private ExternalUrls external_urls;
                        private String href;
                        private String id;
                        private String name;
                        private String type;
                        private String uri;

                        @Getter
                        private static class ExternalUrls {
                            private String spotify;
                        }
                    }

                    @Getter
                    private static class ExternalIds {
                        private String isrc;
                    }

                    @Getter
                    private static class ExternalUrls {
                        private String spotify;
                    }
                }

                @Getter
                private static class VideoThumbnail {
                    private String url;
                }
            }
        }
        public TracksMainDto toTracks() {
            List<TracksMainDto.Track> trackList = new ArrayList<>();
            for (Tracks.Item item : tracks.getItems()) {

                List<TracksMainDto.Track.Image> images = new ArrayList<>();
                for (Tracks.Item.Track.Album.Image image : item.getTrack().getAlbum().getImages()) {
                    TracksMainDto.Track.Image buildImage = TracksMainDto.Track.Image.builder()
                            .url(image.getUrl())
                            .width(image.getWidth())
                            .height(image.getHeight())
                            .build();

                    images.add(buildImage);
                }

                List<String> artists = new ArrayList<>();
                for (Tracks.Item.Track.Artist artist : item.getTrack().getArtists()) {
                    artists.add(artist.getName());
                }

                TracksMainDto.Track track = TracksMainDto.Track.builder()
                        .id(item.getTrack().getId())
                        .name(item.getTrack().getName())
                        .images(images)
                        .artists(artists)
                        .previewUrl(item.getTrack().getPreview_url())
                        .build();

                trackList.add(track);
            }

            return TracksMainDto.builder()
                    .provider(Provider.SPOTIFY)
                    .tracks(trackList)
                    .build();
        }
    }
}