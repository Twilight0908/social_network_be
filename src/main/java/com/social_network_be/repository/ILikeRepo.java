package com.social_network_be.repository;

import com.social_network_be.model.Like;
import com.social_network_be.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface ILikeRepo extends CrudRepository<Like, Integer> {
    int countByPost(Post post);
}
