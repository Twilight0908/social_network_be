package com.social_network_be.service.impl;

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
        return null;
    }

    @Override
    public Follow edit(Follow follow) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Follow findById(int id) {
        return null;
    }

    @Override
    public List<Follow> getAll() {
        return null;
    }
}
