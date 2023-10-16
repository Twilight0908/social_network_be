package com.social_network_be.model.dto;

import com.social_network_be.model.Account;
import com.social_network_be.model.Relationship;

import java.time.LocalDateTime;

public class MessageServiceModel {
    private String id;
    private Account fromUser;
    private Account toUser;
    private Relationship relationship;
    private String subject;
    private String content;
    private int status;
    private LocalDateTime time;

    public MessageServiceModel() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Account getFromUser() {
        return this.fromUser;
    }

    public void setFromUser(Account fromUser) {
        this.fromUser = fromUser;
    }

    public Account getToUser() {
        return this.toUser;
    }

    public void setToUser(Account toUser) {
        this.toUser = toUser;
    }

    public Relationship getRelationship() {
        return this.relationship;
    }

    public void setRelationship(Relationship relationship) {
        this.relationship = relationship;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getTime() {
        return this.time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}