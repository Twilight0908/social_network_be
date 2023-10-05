package com.social_network_be.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Account account;
    @ManyToOne
    private Post post;

    public Like() {
    }
}