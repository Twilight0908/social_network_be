package com.social_network_be.controller;

import com.social_network_be.model.Account;
import com.social_network_be.model.Post;
import com.social_network_be.service.iService.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/apiPost")
public class PostController {
    @Autowired
    IPostService postService;
    @Value("${upload.profile.path}")
    private String fileUpload;

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Account account
            , @RequestParam(value = "content") String content
            , @RequestParam("file") MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String filePath = fileUpload + "/" + fileName;
        File imageFile = new File(filePath);
        if (!imageFile.exists()) {
            file.transferTo(imageFile);
        }
        Post newPost = new Post();
        newPost.setContent(content);
        newPost.setTime(LocalDateTime.now());
        newPost.setLoggedInUser(account);
        newPost.setImage(fileName);
        return new ResponseEntity<>(postService.save(newPost), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Post>> finAll(){
        return ResponseEntity.ok(postService.getAll());
    }
}