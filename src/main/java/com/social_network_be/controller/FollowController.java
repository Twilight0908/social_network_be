package com.social_network_be.controller;

import com.social_network_be.model.Account;
import com.social_network_be.model.Follow;
import com.social_network_be.model.FriendRequest;
import com.social_network_be.service.iService.IAccountService;
import com.social_network_be.service.iService.IFollowService;
import com.social_network_be.service.iService.IFriendRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/apiFollow")
public class FollowController {
    @Autowired
    IFriendRequestService friendRequestService;
    @Autowired
    IFollowService followService;
    @Autowired
    IAccountService accountService;
//    gửi lời mời kết bạn
    @PostMapping("addFriendRequest")
    public FriendRequest addFriendRequest(@RequestBody FriendRequest friendRequest){
        List<FriendRequest> friendRequests = friendRequestService.getAll();
        for (int i = 0; i < friendRequests.size(); i++) {
            if (friendRequests.get(i).getFromUser().getId() == friendRequest.getFromUser().getId() && friendRequests.get(i).getToUser().getId() == friendRequest.getToUser().getId()){
                throw new RuntimeException();
            }
        }
        return friendRequestService.save(friendRequest);
    }
//    api lấy danh sách lời mời
    @GetMapping("/getFriendRequest/{id}")
    public List<FriendRequest> getAllFriendRequest(@PathVariable int id){
        Account fromUser = accountService.findById(id);
        List<FriendRequest> friendRequests = friendRequestService.findAllByFromUser(fromUser);
        for (int i = 0; i < friendRequests.size(); i++) {
            friendRequests.get(i).getFromUser().setUsername("0");
            friendRequests.get(i).getFromUser().setPassword("0");
            friendRequests.get(i).getToUser().setUsername("0");
            friendRequests.get(i).getToUser().setPassword("0");
        }
        return friendRequests;
    }
//    api chấp nhận kết bạn
    @GetMapping("/acceptFriend/{id}")
    public Follow acceptFriend(@PathVariable int id){
        FriendRequest friendRequest = friendRequestService.findById(id);
        Follow follow = new Follow();
        follow.setAccount(friendRequest.getFromUser());
        follow.setFollowedAccount(friendRequest.getToUser());
        return followService.save(follow);
    }
//    api delete bạn bè
    @GetMapping("/deleteFollow/{id}")
    public void deleteFollow(@PathVariable int id){
        followService.delete(id);
    }
//    api danh sách bạn bè
    @GetMapping("/allFollow/{id}")
    public List<Follow> finAllFollow(@PathVariable int id){
        Account account = accountService.findById(id);
        return followService.findAllByAccount(account);
    }
//    api xóa lời mời kết bạn
    @GetMapping("/deleteFriendRequest/{id}")
    public void deleteFriendRequest(@PathVariable int id){
        friendRequestService.delete(id);
    }
}