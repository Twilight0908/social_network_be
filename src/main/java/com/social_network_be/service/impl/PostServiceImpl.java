package com.social_network_be.service.impl;

import com.social_network_be.model.Post;
import com.social_network_be.repository.IPostRepo;
import com.social_network_be.service.iService.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
<<<<<<< HEAD
@Service
public class PostServiceImpl implements IPostService {
    @Autowired
    IPostRepo postRepo;
=======

@Service
public class PostServiceImpl implements IPostService {
    @Autowired
    private IPostRepo postRepo;
>>>>>>> b9b38257503e2f2dcd1fff36d68eb0ea50ec5b84

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
<<<<<<< HEAD
          postRepo.deleteById(id);
=======
        postRepo.deleteById(id);
>>>>>>> b9b38257503e2f2dcd1fff36d68eb0ea50ec5b84
    }

    @Override
    public Post findById(int id) {
        return postRepo.findById(id).get();
    }

    @Override
    public List<Post> getAll() {
<<<<<<< HEAD
        return postRepo.findAll();
    }
}
=======
        return (List<Post>) postRepo.findAll();
    }
}
>>>>>>> b9b38257503e2f2dcd1fff36d68eb0ea50ec5b84
