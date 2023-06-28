package com.example.blogpage.repo;

import com.example.blogpage.entity.Blog;
import com.example.blogpage.entity.Category;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BlogRepository extends PagingAndSortingRepository<Blog, Integer> {
    List<Blog> findAllByNameContaining( String name);
    Iterable<Blog> findAllByCategory(Category category);
    @Query(value = "select b from Blog b order by b.dateRelease")
    List<Blog> sortByDate();
}
