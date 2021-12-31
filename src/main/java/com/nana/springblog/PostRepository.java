package com.nana.springblog;

import com.nana.springblog.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post , Long> {
}
