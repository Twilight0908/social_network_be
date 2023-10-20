package com.social_network_be.controller;

import com.social_network_be.model.Account;
import com.social_network_be.model.Post;
import com.social_network_be.model.Status;
import com.social_network_be.service.iService.IAccountService;
import com.social_network_be.service.iService.IPostService;
import com.social_network_be.service.iService.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/apiPost")
public class PostController {
    @Autowired
    IPostService postService;
    @Autowired
    IAccountService accountService;
    @Autowired
    IStatusService statusService;

    @GetMapping("/apiStatus")
    public ResponseEntity<List<Status>> getAllStatus() {
        return ResponseEntity.ok(statusService.getAll());
    }

    @PostMapping("/createPost")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        post.setTime(LocalDateTime.now());
        return new ResponseEntity<>(postService.save(post), HttpStatus.CREATED);
    }
    @PostMapping("/updatePost")
    public ResponseEntity<Post> updatePost(@RequestBody Post post){
        Post ePost = postService.findById(post.getId());
        post.setTime(ePost.getTime());
        return new ResponseEntity<>(postService.save(post), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Post>> finAll() {
        return ResponseEntity.ok(postService.getAll());
    }

    @PostMapping("/delete/{postId}")
    public ResponseEntity<HttpStatus> deletePost(@PathVariable int postId) {
        Optional<Post> postToDelete = Optional.ofNullable(postService.findById(postId));
        postToDelete.ifPresent(post -> postService.delete(post.getId()));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getPostFollow/{idAccount}")
    public ResponseEntity<List<Post>> getAllPostByFollow(@PathVariable int idAccount) {
        return ResponseEntity.ok(postService.getAllByFollow(idAccount));
    }

    @GetMapping("/getAllByAccount/{idAccount}")
    public ResponseEntity<List<Post>> getAllByAccount(@PathVariable int idAccount) {
        return ResponseEntity.ok(postService.getAllByUserId(idAccount));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable int id){
        return ResponseEntity.ok(postService.findById(id));
    }
}