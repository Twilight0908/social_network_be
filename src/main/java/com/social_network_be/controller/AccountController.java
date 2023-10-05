package com.social_network_be.controller;

import com.social_network_be.model.Account;
import com.social_network_be.service.iService.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

@RestController
@CrossOrigin("*")
@RequestMapping("/apiAccount")
public class AccountController {
    @Autowired
    private IAccountService accountService;
    @Value("${upload.profile.path}")
    private String fileUpload;

    @GetMapping("/account/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable int id) {
        return new ResponseEntity<>(accountService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/account/edit/{id}")
    public ResponseEntity<Account> editAccount(@PathVariable int id,
//                                               @RequestParam("file") MultipartFile file,
                                               @RequestParam(value = "firstName") String firstName,
                                               @RequestParam(value = "lastName") String lastName,
                                               @RequestParam(value = "email") String email,
                                               @RequestParam(value = "gender") boolean gender,
                                               @RequestParam(value = "birthday") String birthday,
                                               @RequestParam(value = "phone") String phone) throws IOException {
        Account account = accountService.findById(id);
        account.setFirstName(firstName);
        account.setLastName(lastName);
        account.setEmail(email);
        account.setGender(gender);
        account.setBirthday(LocalDate.parse(birthday));
        account.setPhone(phone);
//        if (file != null) {
//            String fileName = file.getOriginalFilename();
//            String filePath = fileUpload + "/" + fileName;
//            File imageFile = new File(filePath);
//            if (!imageFile.exists()) {
//                file.transferTo(imageFile);
//            }
//            account.setAvatar(fileName);
//        }
        return new ResponseEntity<>(accountService.edit(account), HttpStatus.OK);
    }
}
