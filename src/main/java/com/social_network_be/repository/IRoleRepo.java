package com.social_network_be.repository;

import com.social_network_be.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface IRoleRepo extends CrudRepository<Role, Integer> {
}
