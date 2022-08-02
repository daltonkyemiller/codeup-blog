package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String index() {
        return "This will display all the posts!";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String post(@PathVariable int id) {
        return "This will display the post with id: " + id;
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
