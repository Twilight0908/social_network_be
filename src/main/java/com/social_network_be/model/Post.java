package com.social_network_be.model;

import lombok.Data;
<<<<<<< HEAD

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@Data
@Entity
@Table(name = "posts")
=======
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
>>>>>>> b9b38257503e2f2dcd1fff36d68eb0ea50ec5b84
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
<<<<<<< HEAD
    @ManyToOne
    private Account loggedInUser;
    @Lob
    private String content;
    private String image;
    private LocalDateTime time;

    public Post() {
    }
}
=======
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
>>>>>>> b9b38257503e2f2dcd1fff36d68eb0ea50ec5b84
