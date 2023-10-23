package com.social_network_be.repository;

import com.social_network_be.model.Account;
import com.social_network_be.model.FriendRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFriendRequestRepo extends JpaRepository<FriendRequest , Integer> {
    List<FriendRequest> findAllByFromUser(Account fromUser);
    List<FriendRequest> findAllByToUser(Account toUser);
}
