package com.nana.springblog.controller;

import com.nana.springblog.model.Author;
import com.nana.springblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api")
public class AuthorController{
    @Autowired
    private BlogService blogService;

    @GetMapping("/authors")
    ResponseEntity<List<Author>> findAllAuthors(){
        return ResponseEntity.ok(blogService.listAllAuthors());
    }


    @GetMapping("/authors/{id}")
    ResponseEntity<Author> findAuthorById(@PathVariable(value = "id") int id) {
        return ResponseEntity.ok(blogService.findAuthorById(id));
    }

    @PostMapping("/authors")
    ResponseEntity<String>  saveAuthor(@RequestBody Author author) {
        //validate email
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(author.getEmail());
        //checking if user exists
        Author authorExists = blogService.findAuthorByEmail(author);
        //validating number
//        todo  validate for gh numbers
        Pattern ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}");
        Matcher match = ptrn.matcher(author.getPhoneNumber());

        if (!matcher.matches()){
            return new ResponseEntity<String>("try using a valid email", HttpStatus.BAD_REQUEST );
        } else if (authorExists != null) {
            return new ResponseEntity<String>("The use already Exist", HttpStatus.BAD_REQUEST );
        } else if (match.matches() == false)
        {
            return new ResponseEntity<String>("Try using a valid phone number" ,HttpStatus.BAD_REQUEST );
        }
        else if (authorExists != null) {
            return new ResponseEntity<String>("The use already Exist", HttpStatus.BAD_REQUEST );
        } else {
            blogService.saveAuthor(author);
            return new ResponseEntity<String>("user saved successfully", HttpStatus.OK);
        }
    }

    @DeleteMapping("/authors/{id}")
    void deleteAuthor(@PathVariable int id) {
        blogService.deleteAuthorById(id);
    }

    @PutMapping("/authors/{id}")
    ResponseEntity<Author>  updateAuthor(@PathVariable int id , @RequestBody Author author)
    {
        return ResponseEntity.ok( blogService.updateAuthor(author, id));
    }


}
