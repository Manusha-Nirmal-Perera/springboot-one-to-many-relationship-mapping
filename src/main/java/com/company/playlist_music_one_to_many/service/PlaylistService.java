package com.company.playlist_music_one_to_many.service;

import com.company.playlist_music_one_to_many.DTO.PlaylistDTO;
import com.company.playlist_music_one_to_many.model.Playlist;

import java.util.List;

public interface PlaylistService {
    Playlist createPlaylist(PlaylistDTO playlistDTO);
    boolean deletePlaylist(Long id);
    List<Playlist> getPlaylist();
    Playlist getPlaylist(Long id);
    Playlist updatePlaylist(Long id, PlaylistDTO playlistDTO);
}
