package com.social_network_be.repository;

import com.social_network_be.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface ICommentRepo extends CrudRepository<Comment, Integer> {
}
