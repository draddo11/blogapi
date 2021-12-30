package com.nana.springblog;

import com.nana.springblog.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository <Author , Long> {
}
