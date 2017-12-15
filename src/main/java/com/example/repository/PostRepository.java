package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
	
	List<Post> findFirst5ByOrderByDateDesc();
	Page<Post> findAllByOrderByDateDesc(Pageable pageable);
	
}
