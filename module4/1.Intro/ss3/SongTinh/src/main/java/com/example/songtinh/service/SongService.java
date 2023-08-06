package com.example.songtinh.service;

import com.example.songtinh.entity.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SongService {
    boolean create(Song song);
    boolean update(Song song);
    List<Song> findAll();
    Song findById(int id);
    boolean deleteById(int id);
    List<Song> findAllByName(String name);
    Page<Song> findAll(Pageable pageable);
    Page<Song> findAllByNameContaining(Pageable pageable, String name);
    Page<Song> findAllByNameAndAuthor(Pageable pageable, String name,String authorName);

}
