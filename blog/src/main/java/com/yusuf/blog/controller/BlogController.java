package com.yusuf.blog.controller;

import com.yusuf.blog.model.Blog;
import com.yusuf.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.ok;

@RestController
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @GetMapping("/blogs")
    public ResponseEntity allBlogs(){
        return ResponseEntity.ok(blogRepository.findAll());
    }

    @GetMapping("/myblogs")
    public ResponseEntity getMyBlogs(@AuthenticationPrincipal UserDetails userDetails){
        return ResponseEntity.ok(blogRepository.findByUsername(userDetails.getUsername()));
    }

    @PostMapping("/blog")
    public ResponseEntity addBlog(@AuthenticationPrincipal UserDetails userDetails, @RequestBody Blog blog){
        blog.setUsername(userDetails.getUsername());
        Blog newBlog = blogRepository.save(blog);
        return ResponseEntity.ok(newBlog);
    }

    @GetMapping("/user")
    public ResponseEntity getSelf (@AuthenticationPrincipal UserDetails userDetails){
        Map<Object, Object> model = new HashMap<>();
        model.put("username", userDetails.getUsername());
        model.put("roles", userDetails.getAuthorities()
                .stream()
                .map(a -> a.getAuthority())
                .collect(toList())
        );
        return ok(model);
    }
}
