package com.social_network_be.repository;

import com.social_network_be.model.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IAccountRepo extends CrudRepository<Account, Integer> {
    Account findByUsername(String username);
    Account findByUsernameAndPassword(String username, String password);
    List<Account> findAllByLastNameContaining(String lastName);
}
