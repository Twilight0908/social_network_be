package com.social_network_be.service.impl;

import com.social_network_be.model.Account;
import com.social_network_be.repository.IAccountRepo;
import com.social_network_be.service.iService.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountRepo iAccountRepo;

    @Override
    public Account findByUsername(String username) {
        return iAccountRepo.findByUsername(username);
    }

    @Override
    public Account findByUsernameAndPassword(String username, String password) {
        return iAccountRepo.findByUsernameAndPassword(username,password);
    }

    @Override
    public List<Account> findAllByFirstNameOrLastNameContaining(String name) {
        return iAccountRepo.findAllByFirstNameOrLastNameContaining(name);
    }

    @Override
    public Account save(Account account) {
        return iAccountRepo.save(account);
    }

    @Override
    public Account edit(Account account) {
        return iAccountRepo.save(account);
    }

    @Override
    public void delete(int id) {
        iAccountRepo.deleteById(id);
    }

    @Override
    public Account findById(int id) {
        return iAccountRepo.findById(id).get();
    }

    @Override
    public List<Account> getAll() {
        return (List<Account>) iAccountRepo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account user = iAccountRepo.findByUsername(username);
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(user.getRole());
        return new org.springframework.security.core.userdetails.User(username, user.getPassword(), roles);
    }
}
