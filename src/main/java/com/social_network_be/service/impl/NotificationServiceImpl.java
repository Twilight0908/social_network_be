package com.social_network_be.service.impl;

import com.social_network_be.model.Account;
import com.social_network_be.model.Notification;
import com.social_network_be.repository.INotificationRepo;
import com.social_network_be.service.iService.INotificationservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements INotificationservice {
    @Autowired
    private INotificationRepo notificationRepo;

    @Override
    public Notification save(Notification notification) {
        return notificationRepo.save(notification);
    }

    @Override
    public Notification edit(Notification notification) {
        return notificationRepo.save(notification);
    }

    @Override
    public void delete(int id) {
        notificationRepo.deleteById(id);
    }

    @Override
    public Notification findById(int id) {
        return notificationRepo.findById(id).get();
    }

    @Override
    public List<Notification> getAll() {
        return notificationRepo.findAll();
    }

    @Override
    public List<Notification> findAllByToUser(Account toUser) {
        return notificationRepo.findAllByToUser(toUser);
    }
}