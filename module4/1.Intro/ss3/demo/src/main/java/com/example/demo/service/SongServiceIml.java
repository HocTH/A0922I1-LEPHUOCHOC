package com.example.demo.service;

import com.example.demo.entity.Song;
import com.example.demo.repo.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class SongServiceIml implements SongService{
    @Autowired
    private SongRepository service;
    @Override
    public boolean create(Song song) {
        service.save(song);
        return true;
    }

    @Override
    public boolean update(Song song) {
        if (service.existsById(song.getId())){
            service.save(song);
            return true;
        }
        return false;
    }

    @Override
    public Song findById(int id) {
        return service.findById(id).orElse(null);
    }

    @Override
    public boolean delete(int id) {
        service.deleteById(id);
        return true;
    }

    @Override
    public List<Song> findAll() {
        return (List<Song>) service.findAll();
    }
}
