package com.example.playlist.service;

import com.example.playlist.entity.Song;
import com.example.playlist.repo.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Service
public class SongServiceImpl  implements SongService{
    @Autowired
    private SongRepository repository;
    @Override
    public boolean create(Song song) {
        repository.save(song);
        return true;
    }

    @Override
    public boolean update(Song song) {
        if(repository.existsById(song.getId())){
            repository.save(song);
        }
        return false;
    }

    @Override
    public Song findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Song> findAll() {
        return (List<Song>) repository.findAll();
    }

    @Override
    public boolean delete(int id) {
        repository.deleteById(id);
        return true;
    }
}
