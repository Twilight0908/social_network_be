package com.social_network_be.service.impl;

import com.social_network_be.model.Post;
import com.social_network_be.repository.IPostRepo;
import com.social_network_be.service.iService.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostServiceImpl implements IPostService {
    @Autowired
    IPostRepo postRepo;

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