package com.nana.springblog.service;

import com.nana.springblog.AuthorRepository;
import com.nana.springblog.CategoryRepository;
import com.nana.springblog.PostRepository;
import com.nana.springblog.model.Author;
import com.nana.springblog.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private PostRepository postRepository;


    public List<Author> listAllAuthors(){
        return authorRepository.findAll();
    }
    public Author saveAuthor(Author author){
        return authorRepository.save(author);
    }

    public Author findAuthorById(Long id){
        return authorRepository.getById(id);
    }
    public Author findAuthorByEmail(Author author){
        return authorRepository.findByEmail(author.getEmail());
    }



    public void  deleteAuthorById(Long id){
        authorRepository.deleteById(id);
    }

    public Author updateAuthor(Author newauthor , Long id ){
        return authorRepository.findById(id)
                .map(author -> {
                    author.setFirstName(newauthor.getFirstName());
                    author.setLastName(newauthor.getLastName());
                    author.setEmail(newauthor.getEmail());
                    author.setPhoneNumber(newauthor.getPhoneNumber());
                    return authorRepository.save(author);
                }).orElseGet(() ->{
                    newauthor.setId(id);
                    return authorRepository.save(newauthor);
                });
    }


    // posts


    public Post savePost(Post post){
        return postRepository.save(post);
    }

    public List<Post> listAllPost(){
        return  postRepository.findAll();
    }

    public Post findPostById(Long id){
        return postRepository.getById(id);
    }


    public  void deletePostById(Long id)
    {
        postRepository.deleteById(id);
    }

    public Post updatePost(Post newpost, Long id){
        return postRepository.findById(id)
                .map(newPost -> {
                    newPost.setTitle(newpost.getTitle());
                    newPost.setText(newpost.getText() );
//                    newPost.setCategories(newpost.getCategories());
                    return postRepository.save(newpost);
                })
                .orElseGet(() ->{
                    newpost.setId(id);
                    return  postRepository.save(newpost);
                });
    }





}
