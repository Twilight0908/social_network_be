package com.social_network_be.repository;

import com.social_network_be.model.Follow;
import org.springframework.data.repository.CrudRepository;

public interface IFollowRepo extends CrudRepository<Follow, Integer> {

}
