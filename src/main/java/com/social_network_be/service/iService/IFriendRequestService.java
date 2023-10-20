package com.social_network_be.service.iService;

import com.social_network_be.model.Account;
import com.social_network_be.model.FriendRequest;

import java.util.List;

public interface IFriendRequestService extends IService<FriendRequest>{
    List<FriendRequest> findAllByFromUser(Account fromUser);
}
