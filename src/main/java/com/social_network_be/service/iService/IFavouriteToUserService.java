package com.social_network_be.service.iService;

import com.social_network_be.model.Account;
import com.social_network_be.model.FavouriteToUser;

import java.util.List;

public interface IFavouriteToUserService extends IService<FavouriteToUser>{
    List<FavouriteToUser> findAllByFromUser(Account fromUser);
    List<FavouriteToUser> findAllByToUser(Account toUser);
}
