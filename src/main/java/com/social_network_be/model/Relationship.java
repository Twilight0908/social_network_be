package com.social_network_be.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@Data
@Entity
public class Relationship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Account userOne;
    @ManyToOne
    private Account userTwo;
    private int status;
    @ManyToOne
    private Account actionUser;
    private LocalDateTime time;
    @OneToMany
    private List<Message> messageList;
}