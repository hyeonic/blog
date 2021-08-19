package me.hyeonic.playlist.feign.spotify;

import me.hyeonic.playlist.dto.social.spotify.playlist.SpotifyPlaylistDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "spotify", url = "https://api.spotify.com")
public interface SpotifyClient {

    @GetMapping("v1/playlists/{playlistId}")
    SpotifyPlaylistDto.Playlist getPlaylist(@RequestHeader("Authorization") String token,
                                            @PathVariable("playlistId") String playlistId);

    @GetMapping("v1/me/playlists")
    SpotifyPlaylistDto.Playlists getPlaylists(@RequestHeader("Authorization") String token);
}