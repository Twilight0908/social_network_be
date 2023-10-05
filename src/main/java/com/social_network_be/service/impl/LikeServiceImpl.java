package com.social_network_be.service.impl;

import com.social_network_be.model.Like;
import com.social_network_be.repository.ILikeRepo;
import com.social_network_be.service.iService.ILikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImpl implements ILikeService {
    @Autowired
    ILikeRepo likeRepo;

    @Override
    public Like save(Like like) {
        return likeRepo.save(like);
    }

    @Override
    public Like edit(Like like) {
        return likeRepo.save(like);
    }

    @Override
    public void delete(int id) {
        likeRepo.deleteById(id);
    }

    @Override
    public Like findById(int id) {
        return likeRepo.findById(id).get();
    }

    @Override
    public List<Like> getAll() {
        return likeRepo.findAll();
    }
}