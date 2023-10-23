package com.social_network_be.controller;

import com.social_network_be.model.Account;
import com.social_network_be.model.FavouriteToUser;
import com.social_network_be.service.iService.IAccountService;
import com.social_network_be.service.iService.IFavouriteToUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/apiFavourite")
public class FavouriteToUserController {
    @Autowired
    private IFavouriteToUserService favouriteToUserService;
    @Autowired
    private IAccountService accountService;
// api theo dõi một người
    @GetMapping("/add/{fromUserId}/{toUserId}")
    public FavouriteToUser addFavourite(@PathVariable int fromUserId,@PathVariable int toUserId) {
        Account fromUser = accountService.findById(fromUserId);
        Account toUser = accountService.findById(toUserId);
        FavouriteToUser favouriteToUser = new FavouriteToUser(fromUser,toUser);
        return favouriteToUserService.save(favouriteToUser);
    }
// api lấy danh sách theo dõi của người gửi
    @GetMapping("/all/{id}")
    public List<FavouriteToUser> getAll(@PathVariable int id) {
        Account account = accountService.findById(id);
        return favouriteToUserService.findAllByFromUser(account);
    }
//    api hủy theo dõi một người
    @GetMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        favouriteToUserService.delete(id);
    }
}