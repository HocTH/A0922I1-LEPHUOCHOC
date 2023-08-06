package com.example.songtinh.repository;

import com.example.songtinh.entity.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SongRepository extends PagingAndSortingRepository<Song, Integer> {
 List<Song> findAllByNameContaining(String name);
 Page<Song> findAll(Pageable pageable);
 Page<Song> findAllByNameContaining(Pageable pageable, String name);
 @Query(value = "select s from Song s where s.name like :name and s.author like :nameAuthor")
 Page<Song> findAllByNameAndAuthor(Pageable pageable, @Param("name") String name, @Param("nameAuthor") String nameAuthor);

}
