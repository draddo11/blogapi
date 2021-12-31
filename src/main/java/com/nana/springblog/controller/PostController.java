package com.nana.springblog.controller;


import com.nana.springblog.PostRepository;
import com.nana.springblog.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public List<Post> findAllPosts(){
        return (List<Post>) postRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findPostById(@PathVariable(value = "id") long id) {
        Optional<Post>  post = postRepository.findById(id);

        if(post.isPresent()) {
            return ResponseEntity.ok().body(post.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public Post savePost(@Validated @RequestBody Post post) {
        return postRepository.save(post);
    }
}
