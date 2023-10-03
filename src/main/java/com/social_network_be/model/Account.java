package com.social_network_be.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private boolean gender;
    @Column(columnDefinition = "TEXT")
    private String avatar;
    @Column(columnDefinition = "TEXT")
    private String thumbnail;
    private LocalDateTime createdAt;

    @ManyToOne
    private Role role;
}
