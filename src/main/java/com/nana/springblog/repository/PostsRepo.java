package com.nana.springblog.repository;

import com.nana.springblog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsRepo extends JpaRepository<Post, Integer> {
    //     @Query( value = "SELECT text , title FROM post JOIN post_categories ON post.id = post_categories.post_id JOIN category  ON category.id = post_categories.category_id WHERE category.name = :war" , nativeQuery = true)
//List<Post> getPostsByCategoryID(@Param("war")  String war);
    @Query( value =  "select text from post where post.ID = :one", nativeQuery = true)
    List<Post> getPostsByCategoryID(@Param("one")  Integer one );

}
