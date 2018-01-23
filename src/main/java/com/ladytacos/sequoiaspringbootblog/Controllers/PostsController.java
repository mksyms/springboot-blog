package com.ladytacos.sequoiaspringbootblog.Controllers;

import com.ladytacos.sequoiaspringbootblog.Models.Post;
import com.ladytacos.sequoiaspringbootblog.Services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostsController {
    private final PostService postService;

    public PostsController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping("/posts")
    public String viewPosts(Model vModel) {
        List<Post> posts= postService.findAllPosts();

        vModel.addAttribute("posts", posts);

        return "posts/index";
    }

    @RequestMapping("/posts/{id}")
    public String viewIndividualPost(@PathVariable String id, Model vModel){
        Post post = new Post("First Post", "Bringing it back to emotionally angsty LiveJournal Days!");
        vModel.addAttribute("post", post);
        vModel.addAttribute("id", id);
        return "posts/show";
    }

    @RequestMapping("/posts/create")
    @ResponseBody
    public String viewCreateForm() {
        return "View form to create a post";
    }

    @RequestMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "Create a new post";
    }
}
