package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Post;
import com.example.service.NotificationService;
import com.example.service.PostService;

@Controller
public class PostController {

	@Autowired
    private PostService postService;
      
	@Autowired
    private NotificationService notifyService;

	@RequestMapping("/posts")
    public String getAllPosts(Model model) {
    	List<Post> list = postService.findAll();
    	model.addAttribute("posts", list);
    	return "posts/posts";
    }
	
	@RequestMapping("/posts/view/{id}")
    public String view(@PathVariable("id") Long id, Model model) {
        Post post = postService.findById(id);
        if (post == null) {
            notifyService.addErrorMessage("Cannot find post #" + id);
            return "redirect:/";
        }
        model.addAttribute("post", post);
        return "posts/view";
    }

	
}
