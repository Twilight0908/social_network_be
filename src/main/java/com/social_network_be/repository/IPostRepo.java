package com.social_network_be.repository;

import com.social_network_be.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPostRepo extends JpaRepository<Post,Integer> {
    @Query("SELECT p FROM Post p WHERE p.loggedInUser.id = :userId ORDER BY p.time DESC")
    List<Post> getAllByUserId(int userId);

    @Query("SELECT p FROM Post p WHERE p.loggedInUser.id IN (SELECT f.followedAccount.id FROM Follow f WHERE f.account.id = :userId) OR p.loggedInUser.id = :userId ORDER BY p.time DESC")
    List<Post> getAllByFollow(@Param("userId") int userId);
}
