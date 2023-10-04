package com.social_network_be.service.impl;

import com.social_network_be.model.Like;
import com.social_network_be.model.Post;
import com.social_network_be.repository.ILikeRepo;
import com.social_network_be.service.iService.ILikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements ILikeService {
    @Autowired
    ILikeRepo likeRepo;
    @Override
    public int countByPostId(Post post) {
        return likeRepo.countByPost(post);
    }

    @Override
    public Like save(Like like) {
        return likeRepo.save(like);
    }

    @Override
    public Like delete(Like like) {
        likeRepo.delete(like);
        return null;
    }
}
