package com.example.blogupdate.repository;

import com.example.blogupdate.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    @Query(value = "select * from Blog where name_blog like :blogName",nativeQuery = true)
    Page<Blog> searchByName(@Param("blogName") String blogName,Pageable pageable);
}
