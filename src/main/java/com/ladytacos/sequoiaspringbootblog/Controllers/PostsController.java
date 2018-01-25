package com.ladytacos.sequoiaspringbootblog.Controllers;

import com.ladytacos.sequoiaspringbootblog.Models.Post;
import com.ladytacos.sequoiaspringbootblog.Services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


//    Dependency injection
//
// 1. Constructor injection (preferred) -> required dependencies
// 2. Setter injection -> optional dependencies


//    How to Approach a New Feature
//
// Page to search posts
// 1. Create a form in the navigation bar
//    - Find the fragment and add a new one for the search form
// 2. Create a controller action to perform the search
//    - Create a SearchController
//    - Method to search by a term (GetMapping /search)
// 3. Write code to query the DB using the term sent by the user
///   - SearchService, will have a method search(term) -> select from posts where title like %term%
//    - probably start with an empty list, then query the DB
// 4 Create/reuse a template to loop over the result of the search
//    public String search(@PathVariable String term) {
//     return 'post/index';  // instead of 'posts/search-result'


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

    // findOne to use with CRUD Repo
    @GetMapping("/posts/{id}")
    public String viewIndividualPost(@PathVariable Long id, Model vModel){
//        Post post = new Post("Test post", "Test body");
//        Post post = postService.findPost(Long.parseLong(id));
//        return "";

        Post post = postService.findOne(id);

        vModel.addAttribute("post", post);
//        vModel.addAttribute("id", id);
        return "posts/show";
    }

    @GetMapping("/posts/show")
    public String showCreateForm(Model vModel) {
        Post post = new Post("Test post", "Test body");
        vModel.addAttribute("post", post);
        return "posts/create";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "Create a new post";
    }
}
