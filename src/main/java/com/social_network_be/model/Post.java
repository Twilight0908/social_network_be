package com.social_network_be.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@Data
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Account loggedInUser;
    @Lob
    private String content;
    private String image;
    private LocalDateTime time;

    public Post() {
    }
}