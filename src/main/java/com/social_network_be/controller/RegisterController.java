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
        user.setAvatar("https://firebasestorage.googleapis.com/v0/b/uploadingfile-7b8bd.appspot.com/o/images%2Favatar-dep-nhat-33_112147.jpgfd5c4dd3-cd7e-4483-aee1-964589dac784?alt=media&token=b27cc73c-9fd8-4167-9b37-256caf8c372e");
        user.setThumbnail("https://firebasestorage.googleapis.com/v0/b/uploadingfile-7b8bd.appspot.com/o/images%2Fanh-bau-troi-dep-hoang-hon-huyen-bi_042052103.jpgbae44423-164d-42ed-95c7-858a1f031187?alt=media&token=d64b3c56-d8ec-4022-8670-8dd58d8c2674");
        user.setCreatedAt(LocalDateTime.now());
        user.setBan(false);
        user.setOnline(false);
        Role role = new Role();
        role.setId(2);
        user.setRole(role);
        return new ResponseEntity<>(accountService.save(user), HttpStatus.CREATED);
    }
}
