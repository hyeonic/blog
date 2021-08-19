package me.hyeonic.playlist.feign.google;

import me.hyeonic.playlist.dto.social.google.playlist.YoutubePlaylistDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "google", url = "https://www.googleapis.com")
public interface GoogleClient {

    @GetMapping("/youtube/v3/playlistItems")
    YoutubePlaylistDto.Playlist getPlaylist(@RequestHeader("Authorization") String token,
                                            @RequestParam("part") String part,
                                            @RequestParam("playlistId") String playlistId,
                                            @RequestParam("maxResults") String maxResults);

    @GetMapping("/youtube/v3/playlists")
    YoutubePlaylistDto.Playlists getPlaylists(@RequestHeader("Authorization") String token,
                                              @RequestParam("part") String part,
                                              @RequestParam("mine") boolean mine);
}