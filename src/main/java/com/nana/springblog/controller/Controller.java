package com.nana.springblog.controller;

import com.nana.springblog.AuthorRepository;
import com.nana.springblog.model.Author;
import com.nana.springblog.model.Post;
import com.nana.springblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
    @RequestMapping("/api/v1")
    public class Controller {

        @Autowired
        private BlogService blogService;

        @GetMapping("/authors")
        ResponseEntity<List <Author>> listAllAuthors(){
            return ResponseEntity.ok(blogService.listAllAuthors());
        }

        @GetMapping("/authors/{id}")
        ResponseEntity <Author> findAuthorById(@PathVariable Long id) {
            return ResponseEntity.ok(blogService.findAuthorById(id));
        }
        @PutMapping("/authors/{id}")
        ResponseEntity<Author> updateAuthor(@RequestBody Author newAuthor, @PathVariable Long id){
            return ResponseEntity.ok(blogService.updateAuthor(newAuthor,id));
        }

         @DeleteMapping("/authors/{id}")
         void deleteAuthor(@PathVariable Long id){
            blogService.deleteAuthorById(id);
         }

        @PostMapping("/authors")
        ResponseEntity <Author> saveAuthor(@Validated @RequestBody Author author) {
            Author exstingAuthor = blogService.findAuthorByEmail(author);
            if(exstingAuthor != null){
                return new ResponseEntity<Author>(HttpStatus.BAD_REQUEST);
            }
            return ResponseEntity.ok(blogService.saveAuthor(author));
        }

//        post mappings

    @GetMapping("/posts")
    ResponseEntity<List <Post>> listAllPost(){
        return ResponseEntity.ok(blogService.listAllPost());
    }

    @GetMapping("/posts/{id}")
    ResponseEntity <Post> findPostById(@PathVariable Long id) {
        return ResponseEntity.ok(blogService.findPostById(id));
    }
    @PutMapping("/posts/{id}")
    ResponseEntity<Post> updatePost(@RequestBody Post newPost, @PathVariable Long id){
        return ResponseEntity.ok(blogService.updatePost(newPost,id));
    }

    @DeleteMapping("/posts/{id}")
    void deletePost(@PathVariable Long id){
        blogService.deletePostById(id);
    }

    @PostMapping("/posts")
    ResponseEntity <Post> savePost(@Validated @RequestBody Post post) {
        return ResponseEntity.ok(blogService.savePost(post));
    }
    }


