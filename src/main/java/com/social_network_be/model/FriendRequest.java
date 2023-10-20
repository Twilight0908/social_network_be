package com.social_network_be.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class FriendRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Account fromUser;
    @ManyToOne
    private Account toUser;
}