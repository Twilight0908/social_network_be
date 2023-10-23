package com.social_network_be.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Account fromUser;
    @ManyToOne
    private Account toUser;
    @Lob
    private String content;
    private boolean check;
    private LocalDateTime time;
}