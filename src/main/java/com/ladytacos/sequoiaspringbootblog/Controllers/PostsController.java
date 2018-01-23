package com.ladytacos.sequoiaspringbootblog.Controllers;

import com.ladytacos.sequoiaspringbootblog.Models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostsController {

    @RequestMapping("/posts")
    public String viewPosts(Model vModel) {
        List<Post> posts= new ArrayList<>();
        Post post1 = new Post("LOREM IPSUM", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.");
        Post post2 = new Post("HODOR IPSUM", "Hodor. Hodor hodor, hodor. Hodor hodor hodor hodor hodor. Hodor. Hodor! Hodor hodor, hodor; hodor hodor hodor. Hodor. Hodor hodor; hodor hodor - hodor, hodor, hodor hodor. Hodor, hodor. Hodor. Hodor, hodor hodor hodor; hodor hodor; hodor hodor hodor! Hodor hodor HODOR! Hodor hodor... Hodor hodor hodor....");
        Post post3 = new Post("HIPSTER IPSUM", "Lorem ipsum dolor amet mustache knausgaard +1, blue bottle waistcoat tbh semiotics artisan synth stumptown gastropub cornhole celiac swag. Brunch raclette vexillologist post-ironic glossier ennui XOXO mlkshk godard pour-over blog tumblr humblebrag. Blue bottle put a bird on it twee prism biodiesel brooklyn. Blue bottle ennui tbh succulents.");
        Post post4 = new Post("HAIRY IPSUM", "Sportacus andrew weatherall goose Refined gentlemen super mario des lynam alpha trion zap rowsdower, omar sharif old man in pub burt reynolds alpha trion sportacus villain Refined gentlemen zap rowsdower funny walk super mario frightfully nice andrew weatherall des lynam goose. Semi beard cream bun disaster alpha trion?");

        posts.add(post1);
        posts.add(post2);
        posts.add(post3);
        posts.add(post4);

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
    public String showCreateForm() {
        return "The form to create a post";
    }

    @RequestMapping("/posts/show")
    @ResponseBody
    public String createPost() {
        return "Store a post in the database";
    }
}
