package com.social_network_be.controller;

import com.social_network_be.model.Account;
import com.social_network_be.model.dto.AccountToken;
import com.social_network_be.service.iService.IAccountService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin("*")
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private IAccountService userService;

    @PostMapping("/login")
    public AccountToken login(@RequestBody Account user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = createToken(user.getUsername());

        Account userGet = userService.findByUsername(user.getUsername());
        userGet.setOnline(true);
        userService.edit(userGet);
        return new AccountToken(
                userGet.getId(),
                userGet.getFirstName(),
                userGet.getLastName(),
                userGet.getUsername(),
                userGet.getEmail(),
                userGet.getPhone(),
                userGet.getBirthday(),
                userGet.getAvatar(),
                userGet.getAddress(),
                userGet.getThumbnail(),
                userGet.getCreatedAt(),
                userGet.isGender(),
                userGet.isBan(),
                userGet.isOnline(),
                token,
                userGet.getRole()
        );
    }

    public static final String PRIVATE_KEY = "abc1234567890xyz";
    private static final long EXPIRE_TIME = 86400L;

    // hàm tạo ra token
    public String createToken(String username) {
        return Jwts.builder()
                .setSubject((username))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + EXPIRE_TIME * 1000))
                .signWith(SignatureAlgorithm.HS512, PRIVATE_KEY)
                .compact();
    }

    @PostMapping("/fail")
    public String checkUser(@RequestBody Account user) { // login fail
        return checkErr(user);
    }

    public String checkErr(Account user) {
        String err = "";
        if (userService.findByUsername(user.getUsername()) != null) {
            if (userService.findByUsernameAndPassword(user.getUsername(), user.getPassword()) == null) {
                err = "wrong password";
            }
        } else {
            err = "wrong username";
        }

        return err;
    }

    @PostMapping("/logout/{id}")
    public ResponseEntity<Account> logout(@PathVariable int id) {
        Account user = userService.findById(id);
        user.setOnline(false);
        return new ResponseEntity<>(userService.edit(user), HttpStatus.OK);
    }
}