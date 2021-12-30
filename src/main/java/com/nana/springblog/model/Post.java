package com.nana.springblog.model;

import javax.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private String text;
    private String postCategories;

    public Post(String title, String text, String postCategories) {
        this.title = title;
        this.text = text;
        this.postCategories = postCategories;
    }

    public Post() {

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

    public String getPostCategories() {
        return postCategories;
    }

    public void setPostCategories(String postCategories) {
        this.postCategories = postCategories;
    }
//    private String author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", postCategories='" + postCategories + '\'' +
                '}';
    }
}
