package com.company.playlist_music_one_to_many.service.Impl;

import com.company.playlist_music_one_to_many.DTO.PlaylistDTO;
import com.company.playlist_music_one_to_many.exceptions.PlaylistNotFoundException;
import com.company.playlist_music_one_to_many.model.Playlist;
import com.company.playlist_music_one_to_many.repository.PlaylistRepository;
import com.company.playlist_music_one_to_many.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Override
    public Playlist createPlaylist(PlaylistDTO playlistDTO) {
        Playlist playlist = new Playlist();
        playlist.setName(playlistDTO.getName());

        playlistRepository.save(playlist);
        return playlist;
    }

    @Override
    public boolean deletePlaylist(Long id) {
        boolean isDeleted = false;
        if(playlistRepository.existsById(id)) {
            playlistRepository.deleteById(id);
            isDeleted = true;
        }else {
            throw new PlaylistNotFoundException("Playlist not found for the id: " + id);
        }
        return isDeleted;
    }

    @Override
    public List<Playlist> getPlaylist() {
        return playlistRepository.findAll();
    }

    @Override
    public Playlist getPlaylist(Long id) {
        return playlistRepository.findById(id)
                .orElseThrow(() -> new PlaylistNotFoundException("Playlist not found for the id: " + id));
    }

    @Override
    public Playlist updatePlaylist(Long id, PlaylistDTO playlistDTO){
        Playlist playlist = playlistRepository.findById(id)
                .orElseThrow(() -> new PlaylistNotFoundException("Playlist not found for id: " + id));
        playlist.setName(playlistDTO.getName());
        return playlistRepository.save(playlist);
    }
}
