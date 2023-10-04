package com.social_network_be.model;

import com.social_network_be.model.Post;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "TEXT")
    private String content;
    private LocalDateTime create_at;
    @ManyToOne
    private Post post;
    @ManyToOne
    private Account account;
}
