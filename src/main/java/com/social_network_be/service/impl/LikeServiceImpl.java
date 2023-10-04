package com.social_network_be.service.impl;

import com.social_network_be.model.Likes;
import com.social_network_be.model.Post;
import com.social_network_be.repository.ILikeRepo;
import com.social_network_be.service.iService.ILikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImpl implements ILikeService {
    @Autowired
    private ILikeRepo likeRepo;

    @Override
    public int countByPostId(Post post) {
        return 0;
    }

    @Override
    public Likes save(Likes likes) {
        return null;
    }

    @Override
    public Likes edit(Likes likes) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Likes findById(int id) {
        return null;
    }

    @Override
    public List<Likes> getAll() {
        return null;
    }
}
