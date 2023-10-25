package com.social_network_be.service.impl;

import com.social_network_be.model.Account;
import com.social_network_be.model.Follow;
import com.social_network_be.repository.IFollowRepo;
import com.social_network_be.service.iService.IFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowServiceImpl implements IFollowService {
    @Autowired
    private IFollowRepo followRepo;

    @Override
    public Follow save(Follow follow) {
        return followRepo.save(follow);
    }

    @Override
    public Follow edit(Follow follow) {
        return followRepo.save(follow);
    }

    @Override
    public void delete(int id) {
       followRepo.deleteById(id);
    }

    @Override
    public Follow findById(int id) {
        return followRepo.findById(id).get();
    }

    @Override
    public List<Follow> getAll() {
        return (List<Follow>) followRepo.findAll();
    }

    @Override
    public List<Follow> findAllByAccountOrFollowedAccount(Account account, Account followedAccount) {
        return followRepo.findAllByAccountOrFollowedAccount(account,followedAccount);
    }
}
