package com.social_network_be.repository;

import com.social_network_be.model.Likes;
import com.social_network_be.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface ILikeRepo extends CrudRepository<Likes, Integer> {
    int countByPost(Post post);
}
