package com.social_network_be.model;

import lombok.Data;


import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Account fromUser;
    @ManyToOne
    private Account toUser;
    @ManyToOne
    private Relationship relationship;
    private String subject;
    private String content;
    private int status;
    private LocalDateTime time;
}