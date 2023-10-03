package com.social_network_be.controller;

import com.social_network_be.model.Account;
import com.social_network_be.model.Role;
import com.social_network_be.service.iService.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@CrossOrigin("*")
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private IAccountService accountService;
    @Value("${upload.profile.path}")
    private String fileUpload;

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestParam("file") MultipartFile file,
                                                 @RequestParam(value = "firstName") String firstName,
                                                 @RequestParam(value = "lastName") String lastName,
                                                 @RequestParam(value = "username") String username,
                                                 @RequestParam(value = "password") String password,
                                                 @RequestParam(value = "email") String email,
                                                 @RequestParam(value = "gender") boolean gender,
                                                 @RequestParam(value = "birthday") String birthday,
                                                 @RequestParam(value = "phone") String phone

    ) throws IOException {
        String fileName = file.getOriginalFilename();
        String filePath = fileUpload + "/" + fileName;
        File imageFile = new File(filePath);
        if (!imageFile.exists()) {
            file.transferTo(imageFile);
        }
        Account newAccount = new Account();
        Role role = new Role();
        role.setId(2);
        newAccount.setFirstName(firstName);
        newAccount.setLastName(lastName);
        newAccount.setUsername(username);
        newAccount.setPassword(password);
        newAccount.setEmail(email);
        newAccount.setGender(gender);
        newAccount.setBirthday(LocalDate.parse(birthday));
        newAccount.setPhone(phone);
        newAccount.setOnline(false);
        newAccount.setBan(false);
        newAccount.setAvatar(fileName);
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setRole(role);
        return new ResponseEntity<>(accountService.save(newAccount), HttpStatus.OK);
    }
}
