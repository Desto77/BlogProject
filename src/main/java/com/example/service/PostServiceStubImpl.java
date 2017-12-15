package com.example.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Post;
import com.example.model.User;
import com.example.repository.PostRepository;

@Service
public class PostServiceStubImpl implements PostService {

	@Autowired
	private PostRepository postRepository;

	@Override
	public List<Post> findAll() {
		return postRepository.findAll();
	}

	@Override
	public List<Post> findLatest5() {
		return postRepository.findFirst5ByOrderByDateDesc();
	}

	@Override
	public Post findById(Long id) {
		return postRepository.findOne(id);
	}

	@Override
	public Post create(Post post) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post edit(Post post) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public Post findById(Long id) {
//		return this.posts.stream().filter(p -> Objects.equals(p.getId(), id)).findFirst().orElse(null);
//	}
//
//	@Override
//	public Post create(Post post) {
//		post.setId(this.posts.stream().mapToLong(p -> p.getId()).max().getAsLong() + 1);
//		this.posts.add(post);
//		return post;
//	}
//
//	@Override
//	public Post edit(Post post) {
//		for (int i = 0; i < this.posts.size(); i++) {
//			if (Objects.equals(this.posts.get(i).getId(), post.getId())) {
//				this.posts.set(i, post);
//				return post;
//			}
//		}
//		throw new RuntimeException("Post not found: " + post.getId());
//	}
//
//	@Override
//	public void deleteById(Long id) {
//		for (int i = 0; i < this.posts.size(); i++) {
//			if (Objects.equals(this.posts.get(i).getId(), id)) {
//				this.posts.remove(i);
//				return;
//			}
//		}
//		throw new RuntimeException("Post not found: " + id);
//	}

}
