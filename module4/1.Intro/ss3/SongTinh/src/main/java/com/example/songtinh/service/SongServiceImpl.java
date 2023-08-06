package com.example.songtinh.service;

import com.example.songtinh.entity.Song;
import com.example.songtinh.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SongServiceImpl  implements SongService{
    @Autowired
    private SongRepository repo;
    @Override
    public boolean create(Song song) {
      repo.save(song);
        return true;
    }

    @Override
    public boolean update(Song song) {
        if (repo.existsById(song.getId())){
            repo.save(song);
            return true;
        }
        return false;
    }

    @Override
    public List<Song> findAll() {
        return (List<Song>) repo.findAll();
    }

    @Override
    public Song findById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(int id) {
        if (repo.existsById(id)){
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Song> findAllByName(String name) {
        return repo.findAllByNameContaining(name);
    }

    @Override
    public Page<Song> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public Page<Song> findAllByNameContaining(Pageable pageable, String name) {
        return repo.findAllByNameContaining(pageable,name);
    }
    @Override
    public Page<Song> findAllByNameAndAuthor(Pageable pageable, String name,String nameAuthor) {
        return repo.findAllByNameAndAuthor(pageable,name,nameAuthor);
    }
}
