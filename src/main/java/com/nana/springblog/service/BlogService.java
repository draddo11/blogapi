package com.nana.springblog.service;

import com.nana.springblog.AuthorRepository;
import com.nana.springblog.CategoryRepository;
import com.nana.springblog.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;

@Service
public class BlogService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private PostRepository postRepository;
}
