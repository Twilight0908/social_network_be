package com.social_network_be.controller;

import com.social_network_be.model.Account;
import com.social_network_be.model.dto.AccountToken;
import com.social_network_be.service.iService.IAccountService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@CrossOrigin("*")
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private IAccountService accountService;

    @PostMapping("/login")
    public AccountToken login(@RequestBody Account account) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = createToken(account.getUsername());

        Account accountToken = accountService.findByUsername(account.getUsername());
        return new AccountToken(accountToken.getId(), accountToken.getLastName(), accountToken.getAvatar(), accountToken.getThumbnail(), token, accountToken.getRole());
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
}
