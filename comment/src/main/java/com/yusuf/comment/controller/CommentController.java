package com.yusuf.comment.controller;

import com.yusuf.comment.model.Comment;
import com.yusuf.comment.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @GetMapping("/comments/{blogId}")
    public ResponseEntity getComments(@PathVariable String blogId) {
        List<Comment> comments = commentRepository.findByBlog(blogId);

        return ResponseEntity.ok(comments);
    }

    @PostMapping("/comment")
    public ResponseEntity addComment(@AuthenticationPrincipal UserDetails userDetails, @RequestBody Comment comment){
        comment.setUsername(userDetails.getUsername());
        Comment newComment = commentRepository.save(comment);
        return ResponseEntity.ok(newComment);
    }
}
