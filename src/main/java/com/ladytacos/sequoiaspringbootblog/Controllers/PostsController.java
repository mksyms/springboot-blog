package com.ladytacos.sequoiaspringbootblog.Controllers;

import com.ladytacos.sequoiaspringbootblog.Models.Post;
import com.ladytacos.sequoiaspringbootblog.Services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//    Dependency injection
// 1. Constructor injection (preferred) -> required dependencies
// 2. Setter injection -> optional dependencies

@Controller
public class PostsController {
            // 1. Create an instance variable with your dependency
    private final PostService postService;

            // 2. Inject the dependency through the constructor and assign it to your instance variable
    public PostsController(PostService postService) {
        this.postService = postService; // This the first time we assign something to service
    }

    @RequestMapping("/posts")
    public String viewPosts(Model vModel) {
        List<Post> posts = postService.findAllPosts();
//        List<Post> posts = Arrays.asList(
//        new Post("Post A", "Body A");
//        new Post("Post B", "Body B");
//        new Post("Post C", "Body C");


        vModel.addAttribute("posts", posts);

        return "posts/index";
    }

    @RequestMapping("/posts/{id}")
    public String viewIndividualPost(@PathVariable String id, Model vModel){
//        Post post = new Post("Test post", "Test body");
        Post post = new Post(1, "First Post", "Bringing it back to emotionally angsty LiveJournal Days!");
        vModel.addAttribute("post", post);
        vModel.addAttribute("id", id);
        return "posts/show";
    }

    @RequestMapping("/posts/view")
    @ResponseBody
    public String viewCreateForm() {
        return "View form to create a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "Create a new post";
    }
}
