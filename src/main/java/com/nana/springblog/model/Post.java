package com.nana.springblog.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class Post{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    private String text;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @ManyToMany

    @JoinTable(name = "post_categories",
            joinColumns = @JoinColumn(name = "post_id",
            referencedColumnName ="id"),inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    private Collection <CategoryList> categoryLists;

    public Post() {
    }

    public Post(Integer id, String title, String text, Author author, Collection <CategoryList> categoryLists) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.author = author;
        this.categoryLists = categoryLists;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Collection <CategoryList> getCategoryLists() {
        return categoryLists;
    }

    public void setCategoryLists(Collection<CategoryList> categoryLists) {
        this.categoryLists = categoryLists;
    }
}