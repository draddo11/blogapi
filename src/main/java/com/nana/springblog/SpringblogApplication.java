package com.nana.springblog;

import com.nana.springblog.model.Author;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringblogApplication.class, args);

        @Bean
                public CommandLineRunner run


    }

    private void insertJavaAdvocates(AuthorRepository repository){
        repository.save(new Author("John" , "Maxwell","johnmax@authors.com","+1 0082625372"));
        repository.save(new Author("Mike" , "Nelson","mikenelson@authors.com","+011 082625372"));
        repository.save(new Author("Nick" , "Cage","NickCage@authors.com","+233 2625372"));
        repository.save(new Author("Chris" , "Tucker","christucker@authors.com","+234 09975372"));
    }

}
