package com.social_network_be.service.impl;

import com.social_network_be.model.Account;
import com.social_network_be.model.FavouriteToUser;
import com.social_network_be.repository.IFavouriteToUserRepo;
import com.social_network_be.service.iService.IFavouriteToUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavouriteToUserServiceImpl implements IFavouriteToUserService {
    @Autowired
    IFavouriteToUserRepo favouriteToUserRepo;

    @Override
    public FavouriteToUser save(FavouriteToUser favouriteToUser) {
        return favouriteToUserRepo.save(favouriteToUser);
    }

    @Override
    public FavouriteToUser edit(FavouriteToUser favouriteToUser) {
        return favouriteToUserRepo.save(favouriteToUser);
    }

    @Override
    public void delete(int id) {
      favouriteToUserRepo.deleteById(id);
    }

    @Override
    public FavouriteToUser findById(int id) {
        return favouriteToUserRepo.findById(id).get();
    }

    @Override
    public List<FavouriteToUser> getAll() {
        return favouriteToUserRepo.findAll();
    }


    @Override
    public List<FavouriteToUser> findAllByFromUser(Account fromUser) {
        return favouriteToUserRepo.findAllByFromUser(fromUser);
    }

    @Override
    public List<FavouriteToUser> findAllByToUser(Account toUser) {
        return favouriteToUserRepo.findAllByToUser(toUser);
    }
}