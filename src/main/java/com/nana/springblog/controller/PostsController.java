package com.nana.springblog.controller;


import com.nana.springblog.model.Post;
import com.nana.springblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostsController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/posts")
    ResponseEntity<List<Post>> findAllPosts(){
        return ResponseEntity.ok(blogService.listAllPots());
    }

    @GetMapping("/posts/{id}")
    ResponseEntity<Post> findPostsById(@PathVariable(value = "id") int id) {
        return ResponseEntity.ok(blogService.findPostById(id));
    }

    @PostMapping("/posts/{category_id}/{author_id}")
    ResponseEntity<String> saveAuthor(@PathVariable (value = "category_id") int category_id , @PathVariable (value = "author_id") int author_id , @RequestBody Post post) {
        blogService.savePost(post , category_id, author_id);
        return new ResponseEntity<String> ("post created sucessfully", HttpStatus.OK) ;
    }

    @DeleteMapping("/posts/{id}")
    ResponseEntity<String> deletePost(@PathVariable int id) {
        blogService.deletePostById(id);
        return new ResponseEntity<String> ("post deleted sucessfully", HttpStatus.OK) ;
    }

    @PutMapping("/posts/{id}")
    ResponseEntity<Post>  updatePost(@PathVariable int id , @RequestBody Post post)
    {
        return ResponseEntity.ok( blogService.updatePost(post, id));
    }
}
