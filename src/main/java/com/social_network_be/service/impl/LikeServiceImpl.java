package com.social_network_be.service.impl;

import com.social_network_be.model.Like;
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
    public Like save(Like like) {
        return null;
    }

    @Override
    public Like edit(Like like) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Like findById(int id) {
        return null;
    }

    @Override
    public List<Like> getAll() {
        return null;
    }
}
