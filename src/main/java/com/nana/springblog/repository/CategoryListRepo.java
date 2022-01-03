package com.nana.springblog.repository;

import com.nana.springblog.model.CategoryList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryListRepo extends JpaRepository<CategoryList, Integer> {
    CategoryList findByName(String name);
}