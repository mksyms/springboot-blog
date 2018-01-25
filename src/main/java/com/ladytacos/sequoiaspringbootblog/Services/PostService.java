package com.ladytacos.sequoiaspringbootblog.Services;

import com.ladytacos.sequoiaspringbootblog.Models.Post;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


// Bean - Spring
@Service
public class PostService {
    private List<Post> posts;

    public PostService() {
        this.posts = new ArrayList<>();
        createPosts();
    }

    public Post findPost(long id) {
        return posts.get((int) id - 1);
    }

    public List<Post> findAllPosts() {
        return posts;
    }

    private void save(Post post) {
        post.setId(posts.size() + 1);
    }

    // tests
    private void createPosts(){
        save(new Post("Title A", "Body A"));
        save(new Post("Title B", "Body B"));
        save(new Post("Title C", "Body C"));
//        posts.add(new Post(posts.size() + 1,
//                "BLUTH IPSUM",
//                "A flower in my garden, a mystery in my panties. Heart attack never stopped old Big Bear. I didn't even know we were calling him Big Bear. We never had the chance to. Maybe it was the eleven months he spent in the womb. The doctor said there were claw marks on the walls of her uterus. Yeah, well, have you seen the new Mustang?"));
//        posts.add(new Post(posts.size() + 1,
//                "OBAMA IPSUM",
//                "That is the true genius of America - a faith in simple dreams,, an insistence on small miracles. We meet at one of those defining moments - a moment when our nation is at war, our economy is in turmoil, and the American promise has been threatened once more. We did not go by choice, we went because of necessity."));
//        posts.add(new Post(posts.size() + 1,
//                "PIRATE IPSUM",
//                "Lookout flogging bilge rat main sheet bilge water nipper fluke to go on account heave down clap of thunder. Reef sails six pounders skysail code of conduct sloop cog Yellow Jack gunwalls grog blossom starboard. Swab black jack ahoy Brethren of the Coast schooner poop deck main sheet topmast furl marooned."));
    }
}