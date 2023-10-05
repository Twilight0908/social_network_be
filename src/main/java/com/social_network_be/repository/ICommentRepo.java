package com.social_network_be.repository;

import com.social_network_be.model.Comment;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepo extends JpaRepository<Comment,Integer> {
=======
import org.springframework.data.repository.CrudRepository;

public interface ICommentRepo extends CrudRepository<Comment, Integer> {
>>>>>>> b9b38257503e2f2dcd1fff36d68eb0ea50ec5b84
}
