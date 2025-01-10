package com.company.playlist_music_one_to_many.controller;

import com.company.playlist_music_one_to_many.DTO.PlaylistDTO;
import com.company.playlist_music_one_to_many.model.Playlist;
import com.company.playlist_music_one_to_many.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PatchMapping;

//import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = "api/playlist")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @PostMapping(value = "/add")
    public Playlist createPlaylist(@RequestBody PlaylistDTO playlistDTO){
        return playlistService.createPlaylist(playlistDTO);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deletePlaylist(@PathVariable Long id){
        if(playlistService.deletePlaylist(id)){
            return ResponseEntity.ok("Resource with ID " + id + " deleted successfully.");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource with ID " + id + " not found.");
        }

    }

    @GetMapping(value = "/get/{id}")
    public Playlist getPlaylist(@PathVariable Long id){
        return playlistService.getPlaylist(id);
    }

    @GetMapping(value = "/get")
    public List<Playlist> getPlaylists(){
        return playlistService.getPlaylist();
    }

    @PatchMapping(value = "/{id}")
    public Playlist updatePlaylist(@PathVariable Long id, @RequestBody PlaylistDTO playlistDTO){
        return playlistService.updatePlaylist(id, playlistDTO);
    }

}
