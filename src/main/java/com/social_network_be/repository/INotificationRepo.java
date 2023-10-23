package com.social_network_be.repository;

import com.social_network_be.model.Account;
import com.social_network_be.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface INotificationRepo extends JpaRepository<Notification,Integer> {
    List<Notification> findAllByToUser(Account toUser);
}
