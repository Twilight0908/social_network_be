package com.social_network_be.model;

import lombok.Data;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "TEXT")
    private String content;
    @Column(columnDefinition = "TEXT")
    private String img;
    private LocalDateTime created_at;
    @ManyToOne
    private Account account;
    @ManyToOne
    private Permission permission;
}
