package com.social_network_be.repository;

import com.social_network_be.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepo extends JpaRepository<Comment,Integer> {
    void deleteByPostId(int postId);
    Comment findByContent (String content);
//    List<Comment> findAllByProductId(int productId);
}

