package com.social_network_be.service.impl;

import com.social_network_be.model.Follow;
import com.social_network_be.repository.IFollowRepo;
import com.social_network_be.service.iService.IFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowServiceImpl implements IFollowService {
@Autowired
    IFollowRepo followRepo;
    @Override
    public void delete(Follow follow) {
        followRepo.delete(follow);
    }
}
