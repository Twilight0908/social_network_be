package com.social_network_be.service.iService;

import com.social_network_be.model.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IAccountService extends IService<Account>, UserDetailsService {
    Account findByUsername(String username);
}
