package com.example.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.model.Post;

public interface PostService {

	List<Post> findAll();
	List<Post> findLatest5();
	Page<Post> findPagable(Pageable pageable);
	Post findById(Long id);
	Post create(Post post);
	Post edit(Post post);
	void deleteById(Long id);

}
