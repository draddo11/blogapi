package com.nana.springblog.model;

import javax.persistence.*;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String categoryName;
    private String description;
    @ManyToOne(fetch= FetchType.LAZY, optional = false)
    @JoinColumn(name= "post_id" , nullable = false)
    private Post post;


    public Category(Long id,String categoryName, String description,
                   Post posts
    ) {
        this.id = id;
        this.categoryName = categoryName;
        this.description = description;
        this.post = post;
    }

    public Category() {

    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String text) {
        this.description = text;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", text='" + description + '\'' +
//                ", Categories='" + posts + '\'' +
                '}';
    }
}
