package com.social_network_be.controller;

import com.social_network_be.model.Account;
import com.social_network_be.service.iService.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("*")
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @GetMapping("/apiAccount/allAccount")
    public ResponseEntity<List<Account>> getAllAccount() {
        return new ResponseEntity<>(accountService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/apiAccount/account/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable int id) {
        return new ResponseEntity<>(accountService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/apiUser/user/{id}")
    public ResponseEntity<Account> getUser(@PathVariable int id) {
        return new ResponseEntity<>(accountService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/apiUser/editUser/{id}")
    public ResponseEntity<Account> editUser(@PathVariable int id, @RequestBody Account user) {
        Account eUser = accountService.findById(id);
        eUser.setFirstName(user.getFirstName());
        eUser.setLastName(user.getLastName());
        eUser.setEmail(user.getEmail());
        eUser.setPhone(user.getPhone());
        eUser.setBirthday(user.getBirthday());
        eUser.setAddress(user.getAddress());
        eUser.setGender(user.isGender());
        return new ResponseEntity<>(accountService.edit(eUser), HttpStatus.OK);
    }

    @PostMapping("/apiUser/editUser/{id}/avatar")
    private ResponseEntity<Account> editAvatar(@PathVariable int id, @RequestBody Account user) {
        Account eUser = accountService.findById(id);
        eUser.setAvatar(user.getAvatar());
        return new ResponseEntity<>(accountService.edit(eUser), HttpStatus.OK);
    }

    @PostMapping("/apiUser/editUser/{id}/thumbnail")
    private ResponseEntity<Account> editThumbnail(@PathVariable int id, @RequestBody Account user) {
        Account eUser = accountService.findById(id);
        eUser.setThumbnail(user.getThumbnail());
        return new ResponseEntity<>(accountService.edit(eUser), HttpStatus.OK);
    }
    @GetMapping("/apiAccount/search/{lastname}")
    public List<Account> search(@PathVariable String lastname){
        List<Account> searchAccount = accountService.findAllByLastNameContaining(lastname);
        for (int i = 0; i < searchAccount.size(); i++) {
            searchAccount.get(i).setPassword("0");
            searchAccount.get(i).setUsername("0");
        }
        return searchAccount;
    }
    @PostMapping("/editUser/password/{id}/{password}")
    private ResponseEntity<Account> editPassword(@PathVariable int id, @PathVariable String password) {
        Account eUser = accountService.findById(id);
            eUser.setPassword(password);
        return new ResponseEntity<>(accountService.edit(eUser), HttpStatus.OK);
    }
}
