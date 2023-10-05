package com.social_network_be.repository;

import com.social_network_be.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILikeRepo extends JpaRepository<Like,Integer> {

}
