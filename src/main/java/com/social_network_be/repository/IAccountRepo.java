package com.social_network_be.repository;

import com.social_network_be.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface IAccountRepo extends CrudRepository<Account, Integer> {
    Account findByUsername(String username);
}
