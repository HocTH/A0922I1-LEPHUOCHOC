package com.example.playlist.repo;

import com.example.playlist.entity.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Integer> {
}
