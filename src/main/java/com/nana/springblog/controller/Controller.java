package com.nana.springblog.controller;

import com.nana.springblog.AuthorRepository;
import com.nana.springblog.model.Author;
import com.nana.springblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
    @RequestMapping("/api/v1")
    public class Controller {

        @Autowired
        private BlogService blogService;

        @GetMapping("/authors")
        public List<Author> listAllAuthors(){
            return blogService.listAllAuthors();
        }
//
        @GetMapping("/authors/{id}")
        public Author findAuthorById(@PathVariable Long id) {
            return blogService.findAuthorById(id);
//            .orElseThrow(()-> new AuthorNotFoundException(id));
        }
//            if(author.isPresent()) {
//                return ResponseEntity.ok().body(author.get());
//            } else {
//                return ResponseEntity.notFound().build();
//            }
//        }
        @PutMapping("/authors/edit")
        Author updateAuthor(@RequestBody Author newAuthor, @PathVariable Long id){
            return blogService.updateAuthor(newAuthor,id);
        }

         @DeleteMapping("/authors/{id}")
         void deleteAuthor(@PathVariable Long id){
            blogService.deleteAuthorById(id);
         }

        @PostMapping("/new")
        public Author saveAuthor(@Validated @RequestBody Author author) {
            return blogService.saveAuthor(author);
        }
    }


