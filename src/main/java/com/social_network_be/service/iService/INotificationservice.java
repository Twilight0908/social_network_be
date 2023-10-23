package com.social_network_be.service.iService;

import com.social_network_be.model.Account;
import com.social_network_be.model.Notification;

import java.util.List;

public interface INotificationservice extends IService<Notification>{
    List<Notification> findAllByToUser(Account toUser);
}
