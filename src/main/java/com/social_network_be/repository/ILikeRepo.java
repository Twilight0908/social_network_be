package com.social_network_be.repository;

<<<<<<< HEAD
import com.social_network_be.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILikeRepo extends JpaRepository<Like,Integer> {
=======
import com.social_network_be.model.Likes;
import com.social_network_be.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface ILikeRepo extends CrudRepository<Likes, Integer> {
    int countByPost(Post post);
>>>>>>> b9b38257503e2f2dcd1fff36d68eb0ea50ec5b84
}
