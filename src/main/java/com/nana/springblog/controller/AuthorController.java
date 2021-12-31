package com.nana.springblog.controller;

import com.nana.springblog.AuthorRepository;
import com.nana.springblog.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


    @RestController
    @RequestMapping("/api/v1")
    public class AuthorController {

        @Autowired
        private AuthorRepository authorRepository;

        @GetMapping("/authors")
        public List<Author> findAllAuthors(){
            return (List<Author>) authorRepository.findAll();
        }
//
//        @GetMapping("/{id}")
//        public ResponseEntity<Author> findAuthorById(@PathVariable(value = "id") long id) {
//            Optional<Author> author = authorRepository.findById(id);
//
//            if(author.isPresent()) {
//                return ResponseEntity.ok().body(author.get());
//            } else {
//                return ResponseEntity.notFound().build();
//            }
//        }
//
        @PostMapping("/new")
        public Author saveAuthor(@Validated @RequestBody Author author) {
            return authorRepository.save(author);
        }
    }


