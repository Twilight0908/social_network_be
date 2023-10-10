package com.social_network_be.model;

import com.social_network_be.model.Post;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
    @ManyToOne
    private Account creator;
    @Lob
    private String content;
    private LocalDateTime time;

    public Comment() {
    }

}

