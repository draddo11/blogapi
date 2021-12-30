package com.nana.springblog;

import com.nana.springblog.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category ,Long> {
}
