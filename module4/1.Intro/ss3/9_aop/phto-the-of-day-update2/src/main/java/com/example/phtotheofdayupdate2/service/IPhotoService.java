package com.example.phtotheofdayupdate2.service;

import com.example.phtotheofdayupdate2.entity.Photo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPhotoService {
    void create(Photo photo);
    List<Photo> showAll();
    Page<Photo> findAllTodayPaging(String date,Pageable pageable);



    void addLike(Photo photo);


    Photo findById(int id);
}
