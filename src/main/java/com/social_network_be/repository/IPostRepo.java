package com.social_network_be.repository;

import com.social_network_be.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepo extends JpaRepository<Post,Integer> {

}
