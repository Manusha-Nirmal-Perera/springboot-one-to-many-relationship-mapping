package com.company.playlist_music_one_to_many.repository;

import com.company.playlist_music_one_to_many.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
}
