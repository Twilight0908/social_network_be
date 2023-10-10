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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
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
    @Value("${upload.profile.path}")
    private String fileUpload;
    @GetMapping("/apiStatus")
    public ResponseEntity<List<Status>> getAllStatus(){
        return ResponseEntity.ok(statusService.getAll());
    }
    @PostMapping("{id}")
    public ResponseEntity<Post> createPost(@PathVariable int id
            , @RequestParam(value = "content") String content
            , @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        String fileName = null;
        int count = 0;
        if(content != null){
            count ++;
        }
        if (file != null) {
            count ++;
            fileName = file.getOriginalFilename();
            String filePath = fileUpload + "/" + fileName;
            File imageFile = new File(filePath);
            if (!imageFile.exists()) {
                file.transferTo(imageFile);
            }
        }

        Post newPost = new Post();
        newPost.setContent(content);
        newPost.setTime(LocalDateTime.now());
        newPost.setLoggedInUser(accountService.findById(id));
        newPost.setImage(fileName);
        if(count <= 0){
            return new ResponseEntity<>(newPost , HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(postService.save(newPost), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Post>> finAll(){
        return ResponseEntity.ok(postService.getAll());
    }
    @PostMapping("/delete/{postId}")
    public ResponseEntity<HttpStatus> deletePost(@PathVariable int postId) {
        Optional<Post> postToDelete = Optional.ofNullable(postService.findById(postId));
        postToDelete.ifPresent(post -> postService.delete(post.getId()));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}