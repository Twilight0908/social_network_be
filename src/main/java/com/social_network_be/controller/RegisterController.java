package com.social_network_be.controller;

import com.social_network_be.model.Account;
import com.social_network_be.model.Role;
import com.social_network_be.service.iService.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@CrossOrigin("*")
public class RegisterController {
    @Autowired
    private IAccountService accountService;
//    @Value("${upload.profile.path}")
//    private String fileUpload;

//    @PostMapping
//    public ResponseEntity<Account> createAccount(@RequestParam("file") MultipartFile file,
//                                                 @RequestParam(value = "firstName") String firstName,
//                                                 @RequestParam(value = "lastName") String lastName,
//                                                 @RequestParam(value = "username") String username,
//                                                 @RequestParam(value = "password") String password,
//                                                 @RequestParam(value = "email") String email,
//                                                 @RequestParam(value = "gender") boolean gender,
//                                                 @RequestParam(value = "birthday") String birthday,
//                                                 @RequestParam(value = "phone") String phone
//
//    ) throws IOException {
//        String fileName = file.getOriginalFilename();
//        String filePath = fileUpload + "/" + fileName;
//        File imageFile = new File(filePath);
//        if (!imageFile.exists()) {
//            file.transferTo(imageFile);
//        }
//        Account newAccount = new Account();
//        Role role = new Role();
//        role.setId(2);
//        newAccount.setFirstName(firstName);
//        newAccount.setLastName(lastName);
//        newAccount.setUsername(username);
//        newAccount.setPassword(password);
//        newAccount.setEmail(email);
//        newAccount.setGender(gender);
//        newAccount.setBirthday(LocalDate.parse(birthday));
//        newAccount.setPhone(phone);
//        newAccount.setOnline(false);
//        newAccount.setBan(false);
//        newAccount.setAvatar(fileName);
//        newAccount.setCreatedAt(LocalDateTime.now());
//        newAccount.setRole(role);
//        return new ResponseEntity<>(accountService.save(newAccount), HttpStatus.OK);
//    }
    @PostMapping("/register")
    public ResponseEntity<Account> createUser(@RequestBody Account user) {
        user.setAvatar("https://firebasestorage.googleapis.com/v0/b/uploadingfile-e1825.appspot.com/o/images%2FAvatar-trang-den.pnge4b89c78-0bbf-4cf1-8450-1da78067593c?alt=media&token=7e278413-55c4-42d2-b4c6-52a96d624e33");
        user.setThumbnail("https://firebasestorage.googleapis.com/v0/b/uploadingfile-e1825.appspot.com/o/images%2F305308526_3179553258977374_1832262922211436074_n.jpg8150ca58-239e-4c4c-b2e6-784d863b51eb?alt=media&token=c0b9913c-7a2f-4818-b520-b1e24a42f1f2");
        user.setCreatedAt(LocalDateTime.now());
        user.setBan(false);
        user.setOnline(false);
        Role role = new Role();
        role.setId(2);
        user.setRole(role);
        return new ResponseEntity<>(accountService.save(user), HttpStatus.CREATED);
    }
}
