package com.yusuf.blog.repository;

import com.yusuf.blog.model.Blog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends MongoRepository<Blog,String> {
    List<Blog> findByUsername(String username);
}
