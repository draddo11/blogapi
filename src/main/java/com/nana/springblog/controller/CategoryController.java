package com.nana.springblog.controller;

import com.nana.springblog.model.CategoryList;
import com.nana.springblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController{
    @Autowired
    private BlogService blogService;

    @GetMapping("/category")
    ResponseEntity<List<CategoryList>> findAllCategory(){
        return ResponseEntity.ok(blogService.listAllCategories());
    }

//    @GetMapping("/category/{name}")
//    ResponseEntity<CategoryList> findCategoryByName(@PathVariable(value = "name") String name) {
//        return ResponseEntity.ok(blogService.findCategoryByName(name));
//    }
    @GetMapping("/category/{id}")
    ResponseEntity<CategoryList> findCategoryById(@PathVariable(value = "id") int id) {
        return ResponseEntity.ok(blogService.findCategoryById(id));
    }
    @PostMapping("/category")
    ResponseEntity<String> createCategory(@RequestBody CategoryList categoryList) {
        blogService.createCategory(categoryList);
        return new ResponseEntity<String>( "Category saved sucessfully" , HttpStatus.OK);
    }
    @PutMapping("/category/{id}")
    ResponseEntity<String> updateCategory(@PathVariable(value = "id") int id, @RequestBody CategoryList categoryList) {
        blogService.updateCategory(categoryList, id);
        return new ResponseEntity<String>("Category updated sucessfully", HttpStatus.OK);
    }
    @DeleteMapping("/category/{id}")
    ResponseEntity<String> deleteCategory(@PathVariable int id) {
        blogService.deleteCategoryById(id);
        return new ResponseEntity<String>("category deleted successfully", HttpStatus.OK);
    }
}
