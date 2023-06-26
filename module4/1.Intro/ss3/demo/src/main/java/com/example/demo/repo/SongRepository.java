package com.example.demo.repo;

import com.example.demo.entity.Song;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SongRepository extends PagingAndSortingRepository<Song, Integer> {
}
