package com.example.demo.service;

import com.example.demo.entity.Song;

import java.util.List;

public interface SongService {
    boolean create(Song song);
    boolean update(Song song);
    Song findById(int id);
    boolean delete(int id);
    List<Song> findAll();
}
