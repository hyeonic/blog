package me.hyeonic.playlist.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.hyeonic.playlist.controller.response.BasicResponse;
import me.hyeonic.playlist.controller.response.CommonResponse;
import me.hyeonic.playlist.dto.nonplaylist.NonPlaylistDto;
import me.hyeonic.playlist.dto.social.TracksMainDto;
import me.hyeonic.playlist.dto.social.google.GoogleTokenInfo;
import me.hyeonic.playlist.dto.social.google.playlist.YoutubePlaylistDto;
import me.hyeonic.playlist.dto.social.spotify.SpotifyTokenInfo;
import me.hyeonic.playlist.dto.social.spotify.playlist.SpotifyPlaylistDto;
import me.hyeonic.playlist.social.GoogleService;
import me.hyeonic.playlist.social.SpotifyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OauthController {

    private final GoogleService googleService;
    private final SpotifyService spotifyService;

    @GetMapping("api/google/callback")
    public ResponseEntity<? extends BasicResponse> googleCallback(@RequestParam String code) {

        GoogleTokenInfo googleTokenInfo = googleService.getAccessToken(code);
        YoutubePlaylistDto.Playlists playlists = googleService.getPlaylists(googleTokenInfo.getTokenTypeAndAccessToken());
//
        NonPlaylistDto.PlayLists nonPlaylists = playlists.toNonPlaylists();

//        YoutubePlaylistDto.Playlist playlist = googleService.getPlaylist(googleTokenInfo.getTokenTypeAndAccessToken());

//        TracksMainDto tracksMainDto = playlist.toTracks();

        return ResponseEntity.ok(new CommonResponse<>(nonPlaylists));
    }

    @GetMapping("api/spotify/callback")
    public ResponseEntity<? extends BasicResponse> spotifyCallback(@RequestParam String code) {

        SpotifyTokenInfo spotifyTokenInfo = spotifyService.getAccessToken(code);
//        SpotifyPlaylistDto.Playlists playlists = spotifyService.getPlaylists(spotifyTokenInfo.getTokenTypeAndAccessToken());
//
//        NonPlaylistDto.PlayLists nonPlaylists = playlists.toNonPlaylists();

        SpotifyPlaylistDto.Playlist playlist = spotifyService.getPlaylist(spotifyTokenInfo.getTokenTypeAndAccessToken());

        TracksMainDto tracksMainDto = playlist.toTracks();

        return ResponseEntity.ok(new CommonResponse<>(tracksMainDto));
    }
}