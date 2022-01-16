package com.nana.springblog.service;

import com.nana.springblog.model.Author;
import com.nana.springblog.model.CategoryList;
import com.nana.springblog.model.Post;
import com.nana.springblog.repository.AuthorRepo;
import com.nana.springblog.repository.CategoryListRepo;
import com.nana.springblog.repository.PostsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    private AuthorRepo authorRepo;
    @Autowired
    private CategoryListRepo categoryListRepo;
    @Autowired
    private PostsRepo postsRepo;


    public List<Author> listAllAuthors(){
        return  authorRepo.findAll();
    }

    public Author findAuthorById(int id){
        return authorRepo.getById(id);
    }
    public Author findAuthorByEmail( Author author){
        return authorRepo.findByEmail(author.getEmail());
    }

    public Author saveAuthor(Author author){
        return authorRepo.save(author);
    }

    public  void deleteAuthorById(int id)
    {
        authorRepo.deleteById(id);
    }

    public Author updateAuthor(Author author, int id){
        return authorRepo.findById(id)
                .map(author1 -> {
                    author1.setFirstName(author.getFirstName());
                    author1.setLastName(author.getLastName() );
                    author1.setEmail(author.getEmail());
                    author1.setPhoneNumber(author.getPhoneNumber());
                    return authorRepo.save(author1);
                })
                .orElseGet(() ->{
                    author.setId(id);
                    return  authorRepo.save(author);
                });
    }
//     posts
    public Post savePost(Post post , Integer author_id, Integer category_id){
        CategoryList categoryList = categoryListRepo.getById(category_id);
        Author author = authorRepo.getById(author_id);
        post.setAuthor(author);
        List <CategoryList> category = Collections.singletonList(categoryList);
        post.setCategoryLists(category);
        return postsRepo.save(post);
    }


    public List<Post> listAllPots(){
        return  postsRepo.findAll();
    }

    public Post findPostById(int id){
        return postsRepo.getById(id);
    }

    public  void deletePostById(int id)
    {
        postsRepo.deleteById(id);
    }
//
    public Post updatePost(Post post, Integer id){
        return postsRepo.findById(id)
                .map(newPost -> {
                    newPost.setTitle(post.getTitle());
                    newPost.setText(post.getText() );
                    return postsRepo.save(newPost);
                })
                .orElseGet(() ->{
                    post.setId(id);
                    return  postsRepo.save(post);
                });
    }

/////////categoryList///////////


    public CategoryList  createCategory(CategoryList categoryList){
        categoryList.setName(categoryList.getName().toLowerCase());
        return categoryListRepo.save(categoryList);
    }

    public List<CategoryList> listAllCategories(){
        return  categoryListRepo.findAll();
    }

    public CategoryList findCategoryById(Integer id){
        return categoryListRepo.getById(id);
    }

    public CategoryList findCategoryByName(String name){
        return categoryListRepo.findByName(name);
    }

    public  void deleteCategoryById(int id)
    {
        categoryListRepo.deleteById(id);
    }

    public CategoryList updateCategory(CategoryList  newCategory, int id){
        return categoryListRepo.findById(id)
                .map(categoryList -> {
                    categoryList.setName(newCategory.getName());
                    return categoryListRepo.save(categoryList);
                })
                .orElseGet(() ->{
                    newCategory.setId(id);
                    return  categoryListRepo.save(newCategory);
                });
    }
//


}