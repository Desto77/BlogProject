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

	
	
	@PostConstruct
	private void init() {
		List<Post> posts = new ArrayList<Post>() {
			{
				add(new Post("First Post", "Line #1.Line #2", "dgdsa astr bfdsdsa rrr", null));
				add(new Post("Second Post", "Second post content: line 1 line 2", "gfdsgfds redfas bhbxcds",
						new User("pesho10", "Peter Ivanov")));
				add(new Post("Post #3", "The post number 3 nice", "gfdsgfds redfas bhbxcds",
						new User("merry", null)));
				add(new Post("Forth Post", "Not interesting post", "gfdsgfds redfas bhbxcds",
						new User("username", "Martin Kogl")));
				add(new Post("Post Number 5", "Just postin", "gfdsgfds redfas bhbxcds", null));
				add(new Post("Sixth Post", "Another interesting post", "gfdsgfds redfas bhbxcds", null));
			}
		};
		postRepository.save(posts);
	}

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
		// TODO Auto-generated method stub
		return null;
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
