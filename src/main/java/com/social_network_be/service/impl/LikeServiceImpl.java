package com.social_network_be.service.impl;

<<<<<<< HEAD
import com.social_network_be.model.Like;
=======
import com.social_network_be.model.Likes;
import com.social_network_be.model.Post;
>>>>>>> b9b38257503e2f2dcd1fff36d68eb0ea50ec5b84
import com.social_network_be.repository.ILikeRepo;
import com.social_network_be.service.iService.ILikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImpl implements ILikeService {
    @Autowired
<<<<<<< HEAD
    ILikeRepo likeRepo;

    @Override
    public Like save(Like like) {
        return likeRepo.save(like);
    }

    @Override
    public Like edit(Like like) {
        return likeRepo.save(like);
=======
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
>>>>>>> b9b38257503e2f2dcd1fff36d68eb0ea50ec5b84
    }

    @Override
    public void delete(int id) {
<<<<<<< HEAD
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
=======

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
>>>>>>> b9b38257503e2f2dcd1fff36d68eb0ea50ec5b84
