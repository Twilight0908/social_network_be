package com.social_network_be.controller;

import com.social_network_be.model.Account;
import com.social_network_be.model.Comment;
import com.social_network_be.model.Post;
import com.social_network_be.repository.ICommentRepo;
import com.social_network_be.service.iService.IAccountService;
import com.social_network_be.service.iService.ICommentService;
import com.social_network_be.service.iService.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/apiComment")
public class CommentController {
    @Autowired
    private ICommentService commentService;
    @Autowired
    private IPostService postService;
    @Autowired
    private IAccountService accountService;

    // Lấy tất cả các bình luận
    @GetMapping
    public ResponseEntity<List<Comment>> getAllComments() {
        List<Comment> comments = commentService.getAll();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    // Thêm một bình luận mới
    @PostMapping
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
        // Đảm bảo rằng comment có thông tin hợp lệ, ví dụ: kiểm tra xem post và creator tồn tại.
//     comment.getPost() truy cập đối tượng bài đăng mà bình luận đó đính kèm. Sau đó, bằng cách gọi .getId(), bạn trích xuất id của bài đăng từ đối tượng bài đăng đó.
        Post post = postService.findById(comment.getPost().getId());
        Account creator = accountService.findById(comment.getCreator().getId());
        if (post != null && creator != null) {
            commentService.save(comment);
            return new ResponseEntity<>(comment, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Cập nhật một bình luận
    @PostMapping ("update/{commentId}")
    public ResponseEntity<Comment> updateComment(@PathVariable int commentId, @RequestBody Comment updatedComment) {
        Comment existingComment = commentService.findById(commentId);
        if (existingComment != null) { // nếu cmt tồn tại
            // Cập nhật thông tin của bình luận
            existingComment.setContent(updatedComment.getContent());
            commentService.edit(existingComment);
            return new ResponseEntity<>(existingComment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Xoá một bình luận
    @PostMapping("delete/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable int commentId) {
        Comment comment = commentService.findById(commentId);
        if (comment != null) {
            commentService.delete(commentId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}