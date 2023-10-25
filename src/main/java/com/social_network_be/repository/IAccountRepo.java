package com.social_network_be.repository;

import com.social_network_be.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAccountRepo extends CrudRepository<Account, Integer> {
    Account findByUsername(String username);
    Account findByUsernameAndPassword(String username, String password);
    @Query("SELECT a FROM Account a WHERE CONCAT(a.firstName, ' ', a.lastName) LIKE %:name%")
    List<Account> findAllByFirstNameOrLastNameContaining(@Param("name") String name);
}
