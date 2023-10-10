package com.social_network_be.controller;

import com.social_network_be.model.Comment;
import com.social_network_be.repository.ICommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/apiComment")
public class CommentController {
    @Autowired
    ICommentRepo commentRepo;
    @GetMapping
    public ResponseEntity<List<Comment>> getAll(){
        return new ResponseEntity<>(commentRepo.findAll(), HttpStatus.OK);
    }
//    @PostMapping
//    public ResponseEntity<Comment> createComment(){
//        return new ResponseEntity<>()
//    }
}