package com.company.playlist_music_one_to_many.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/music")
public class MusicController {

    @PostMapping(value = "/add")
    public void addMusic(){

    }

    @DeleteMapping(value = "/delete/{id}")
    public void removeMusic(){

    }

    @GetMapping(value = "/get")
    public void getAllMusic(){

    }

    @GetMapping(value = "/get/{id}")
    public void getMusic(){

    }

    @PutMapping(value = "/update/{id}")
    public void updateMusic(){

    }
}
