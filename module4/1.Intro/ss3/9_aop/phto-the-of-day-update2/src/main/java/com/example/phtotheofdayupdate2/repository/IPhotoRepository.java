package com.example.phtotheofdayupdate2.repository;


import com.example.phtotheofdayupdate2.entity.Photo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IPhotoRepository extends JpaRepository<Photo, Integer> {

    @Query(value = "select p from Photo p  where p.date = :date")
    Page<Photo> findAllTodayPaging(@Param("date") String date, Pageable pageable);


}
