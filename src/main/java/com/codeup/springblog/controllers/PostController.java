package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {
    private final PostRepository postsDao;
    private final UserRepository usersDao;

    private final EmailService emailService;

    public PostController(PostRepository postsDao, UserRepository usersDao, EmailService emailService) {
        this.postsDao = postsDao;
        this.usersDao = usersDao;
        this.emailService = emailService;
    }

    @GetMapping("/posts")
    public String index(Model model) {
        List<Post> posts = postsDao.findAll();
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String post(@PathVariable long id, Model model) {
        Post post = postsDao.getById(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String create() {
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@RequestParam String title, @RequestParam String body) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post newPost = postsDao.save(new Post(title, body, user));
        emailService.prepareAndSend(newPost, "Post Created Successfully!", "You successfully created a post!");
        return "redirect:/posts";
    }


    @GetMapping("/posts/{id}/edit")
    public String edit(@PathVariable long id, Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user.getId() != postsDao.getById(id).getOwner().getId()) return "redirect:/posts";


        Post post = postsDao.getById(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@PathVariable Long id, @ModelAttribute Post p) {
        System.out.println("testing");
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post post = postsDao.getById(id);
        if (user.getId() != post.getOwner().getId()) return "redirect:/posts";


        post.setTitle(p.getTitle());
        post.setBody(p.getBody());
        postsDao.save(post);

        return "redirect:/posts";
    }

    @GetMapping("/posts/tag/{tag}")
    public String tag(@PathVariable String tag, Model model) {
        List<Post> posts = postsDao.findAllByTagName(tag);
        model.addAttribute("posts", posts);
        return "posts/index";
    }


}
