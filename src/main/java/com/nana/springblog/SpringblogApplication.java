package com.nana.springblog;

import com.nana.springblog.model.Author;
import com.nana.springblog.model.Post;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringblogApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(AuthorRepository repository) {
         return (args -> {
            insertJavaAdvocates(repository);
            System.out.println(repository.findAll());
            });


    }

    private void insertJavaAdvocates(AuthorRepository repository){
        repository.save(new Author("John" , "Maxwell","johnmax@authors.com","+1 0082625372"));
        repository.save(new Author("Mike" , "Nelson","mikenelson@authors.com","+011 082625372"));
        repository.save(new Author("Nick" , "Cage","NickCage@authors.com","+233 2625372"));
        repository.save(new Author("Chris" , "Tucker","christucker@authors.com","+234 09975372"));
    };

    @Bean
    public CommandLineRunner run(PostRepository repository) {
        return (args -> {
            insertJavaAdvocates(repository);
            System.out.println(repository.findAll());
        });


    }

    private void insertJavaAdvocates(PostRepository repository){
        repository.save(new Post("One piece" , "A pirate story","Action"));
        repository.save(new Post("Bleach" , "High school boy discovers new world","Dark Adventure"));
        repository.save(new Post("Harry Potter" , "A young wizard story ","Fiction"));
        repository.save(new Post("Artemis Fowl" , "A young genius spy","sci fi "));
        repository.save(new Post("Introduction to Java " , "A brief introduction to javay","programming"));
        repository.save(new Post("Leadership Principles" , "A guide to all leaders","Business"));
    }

}
