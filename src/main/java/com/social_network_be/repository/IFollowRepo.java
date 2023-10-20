package com.social_network_be.repository;

import com.social_network_be.model.Account;
import com.social_network_be.model.Follow;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IFollowRepo extends CrudRepository<Follow, Integer> {
    List<Follow> findAllByAccount(Account account);

}
