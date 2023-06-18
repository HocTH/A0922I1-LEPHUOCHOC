package com.example.playlist.service;

import com.example.playlist.entity.Song;

import java.util.List;

public interface SongService {
    boolean create(Song t);
    boolean update(Song t);
    Song findById(int id);
    List<Song> findAll();
    boolean delete(int id);
}
