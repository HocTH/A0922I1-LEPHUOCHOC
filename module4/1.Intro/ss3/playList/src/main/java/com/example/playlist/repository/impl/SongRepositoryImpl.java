package com.example.playlist.repository.impl;


import com.example.playlist.entity.Song;
import com.example.playlist.repository.SongRepository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
public class SongRepositoryImpl implements SongRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public boolean create(Song song) {
        entityManager.persist(song);
        return true;
    }

    @Override
    public boolean update(Song song) {
        entityManager.merge(song);
        return true;
    }

    @Override
    public Song findById(int id) {
        return entityManager.find(Song.class, id);
    }

    @Override
    public List<Song> findAll() {
        return entityManager.createQuery("select p from Song p").getResultList();
    }

    @Override
    public boolean delete(int id) {
        entityManager.remove(findById(id));
        return true;
    }
}
