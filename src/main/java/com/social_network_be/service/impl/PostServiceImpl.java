package com.social_network_be.service.impl;

import com.social_network_be.model.Comment;
import com.social_network_be.model.Like;
import com.social_network_be.model.Post;
import com.social_network_be.repository.ICommentRepo;
import com.social_network_be.repository.ILikeRepo;
import com.social_network_be.repository.IPostRepo;
import com.social_network_be.service.iService.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class PostServiceImpl implements IPostService {
    @Autowired
    IPostRepo postRepo;
    @Autowired
    ILikeRepo likeRepo;
    @Autowired
    ICommentRepo commentRepo;

    @Override
    public Post save(Post post) {
        return postRepo.save(post);
    }

    @Override
    public Post edit(Post post) {
        return postRepo.save(post);
    }

    @Override
    public void delete(int id) {
        List<Like> likes = likeRepo.findAll();
        List<Comment> comments = commentRepo.findAll();
        IntStream.range(0, likes.size()).filter(i -> likes.get(i).getPost().getId() == id).forEach(i -> likeRepo.deleteById(likes.get(i).getId()));
        IntStream.range(0, comments.size()).filter(i -> comments.get(i).getPost().getId() == id).forEach(i -> commentRepo.deleteById(comments.get(i).getId()));
      postRepo.deleteById(id);
    }

    @Override
    public Post findById(int id) {
        return postRepo.findById(id).get();
    }

    @Override
    public List<Post> getAll() {
        return postRepo.findAll();
    }
}