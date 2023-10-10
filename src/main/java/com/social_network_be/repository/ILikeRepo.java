package com.social_network_be.repository;

import com.social_network_be.model.Account;
import com.social_network_be.model.Like;
import com.social_network_be.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ILikeRepo extends JpaRepository<Like,Integer> {
//     List<Like> findAllByAccountAAndPost(Account account, Post post);
void deleteByPostId(int postId);
}
