package com.social_network_be.service.impl;

import com.social_network_be.model.Account;
import com.social_network_be.model.FriendRequest;
import com.social_network_be.repository.IFriendRequestRepo;
import com.social_network_be.service.iService.IFriendRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FriendRequestServiceImpl implements IFriendRequestService {
    @Autowired
    IFriendRequestRepo friendRequestRepo;
    @Override
    public FriendRequest save(FriendRequest friendRequest) {
        return friendRequestRepo.save(friendRequest);
    }

    @Override
    public FriendRequest edit(FriendRequest friendRequest) {
        return friendRequestRepo.save(friendRequest);
    }

    @Override
    public void delete(int id) {
         friendRequestRepo.deleteById(id);
    }

    @Override
    public FriendRequest findById(int id) {
        return friendRequestRepo.findById(id).get();
    }

    @Override
    public List<FriendRequest> getAll() {
        return friendRequestRepo.findAll();
    }

    @Override
    public List<FriendRequest> findAllByFromUser(Account fromUser) {
        return friendRequestRepo.findAllByFromUser(fromUser);
    }

    @Override
    public List<FriendRequest> findAllByToUser(Account toUser) {
        return friendRequestRepo.findAllByToUser(toUser);
    }
}