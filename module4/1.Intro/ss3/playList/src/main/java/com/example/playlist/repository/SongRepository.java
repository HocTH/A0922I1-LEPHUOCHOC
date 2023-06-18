package com.example.playlist.repository;

import com.example.playlist.entity.Song;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public interface SongRepository {
    boolean create(Song t);
    boolean update(Song t);
    Song findById(int id);
    List<Song> findAll();
    boolean delete(int id);
}
