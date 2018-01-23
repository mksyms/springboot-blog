package com.ladytacos.sequoiaspringbootblog.Services;

import com.ladytacos.sequoiaspringbootblog.Models.Post;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private List<Post> posts = new ArrayList<>();

    public Post findPost(long id) {
        return posts.get((int)id - 1);
    }

    public List<Post> findAllPosts() {
        return posts;
    }


}