package com.example.service;

import java.util.List;

import com.example.model.Post;

public interface PostService {

	List<Post> findAll();
	List<Post> findLatest5();
	Post findById(Long id);
	Post create(Post post);
	Post edit(Post post);
	void deleteById(Long id);

}
