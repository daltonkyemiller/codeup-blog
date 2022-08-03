package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    @GetMapping("/posts")
    public String index(Model model) {
        Post p1 = new Post(1, "First Post", "This is the first post");
        Post p2 = new Post(2, "Second Post", "This is the second post");
        List<Post> posts = new ArrayList<>();
        posts.add(p1);
        posts.add(p2);
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String post(@PathVariable int id, Model model) {
        model.addAttribute("post", new Post(1, "My First Post", "This is my first post!"));
        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String create() {
        return "This will display the view for creating a post!";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "This will create a post!";
    }
}
