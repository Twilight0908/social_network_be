package com.social_network_be.repository;

import com.social_network_be.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface IPostRepo extends CrudRepository<Post, Integer> {
}
