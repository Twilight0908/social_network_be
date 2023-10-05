package com.social_network_be.repository;

import com.social_network_be.model.Post;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepo extends JpaRepository<Post,Integer> {

=======
import org.springframework.data.repository.CrudRepository;

public interface IPostRepo extends CrudRepository<Post, Integer> {
>>>>>>> b9b38257503e2f2dcd1fff36d68eb0ea50ec5b84
}
