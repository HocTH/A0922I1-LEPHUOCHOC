package com.example.phtotheofdayupdate2.service;


import com.example.phtotheofdayupdate2.entity.Photo;
import com.example.phtotheofdayupdate2.repository.IPhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PhotoServiceImpl implements IPhotoService{
    @Autowired
    private IPhotoRepository repository;
    @Override
    public void create(Photo photo) {
        photo.setDate();
       repository.save(photo);
    }

    @Override
    public List<Photo> showAll() {
        return repository.findAll();
    }

    @Override
    public Page<Photo> findAllTodayPaging(String date, Pageable pageable) {
        return repository.findAllTodayPaging(date,pageable);
    }

    @Override
    public void addLike(Photo photo) {
        photo.setLikes(photo.getLikes()+1);
        repository.save(photo);
    }



    @Override
    public Photo findById(int id) {
       return repository.findById(id).orElse(null);
    }
}
