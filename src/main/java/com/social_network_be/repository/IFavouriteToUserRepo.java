package com.social_network_be.repository;

import com.social_network_be.model.Account;
import com.social_network_be.model.FavouriteToUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFavouriteToUserRepo extends JpaRepository<FavouriteToUser , Integer> {
    List<FavouriteToUser> findAllByFromUser(Account account);
    List<FavouriteToUser> findAllByToUser(Account toUser);
}
