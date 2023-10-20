package com.social_network_be.service.iService;

import com.social_network_be.model.Account;
import com.social_network_be.model.Follow;

import java.util.List;

public interface IFollowService extends IService<Follow> {
    List<Follow> findAllByAccount(Account account);
}
