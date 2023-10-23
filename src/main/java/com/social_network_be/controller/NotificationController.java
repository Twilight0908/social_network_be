package com.social_network_be.controller;

import com.social_network_be.model.Account;
import com.social_network_be.model.Notification;
import com.social_network_be.service.iService.IAccountService;
import com.social_network_be.service.iService.INotificationservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/apiNotification")
public class NotificationController {
    @Autowired
    private INotificationservice notificationservice;
    @Autowired
    private IAccountService accountService;
    @PostMapping("/add")
    public Notification creatNotification(@RequestBody Notification notification){
        return notificationservice.save(notification);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Notification>> getAll(){
        return ResponseEntity.ok(notificationservice.getAll());
    }
    @GetMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        notificationservice.delete(id);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Notification> findById(@PathVariable int id){
        return ResponseEntity.ok(notificationservice.findById(id));
    }
    @GetMapping("/allUser/{id}")
    public List<Notification> findAllByToUser(@PathVariable int id){
        Account toUser = accountService.findById(id);
        return notificationservice.findAllByToUser(toUser);
    }

}