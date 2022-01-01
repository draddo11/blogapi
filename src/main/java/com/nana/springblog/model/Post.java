package com.nana.springblog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String text;


    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="author_id", nullable = false)
    private Author author;

//    @OneToMany(mappedBy = "post")
//    private List <Category> categories;

    public Post() {
    }

    public Post(String title, String text, Author author, List<Category> categories) {
        this.title = title;
        this.text = text;
        this.author = author;
//        this.categories = categories;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

//    public List<Category> getCategories() {
//        return categories;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public void setCategories(List<Category> categories) {
//        this.categories = categories;
//    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", author=" + author +
//                ", categories=" + categories +
                '}';
    }
}
