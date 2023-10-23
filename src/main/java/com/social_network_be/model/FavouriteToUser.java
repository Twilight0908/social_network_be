package com.social_network_be.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class FavouriteToUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    Account fromUser;
    @ManyToOne
    Account toUser;

    public FavouriteToUser(Account fromUser) {
        this.fromUser = fromUser;
    }

    public FavouriteToUser(Account fromUser, Account toUser) {
        this.fromUser = fromUser;
        this.toUser = toUser;
    }

    public FavouriteToUser() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getFromUser() {
        return fromUser;
    }

    public void setFromUser(Account fromUser) {
        this.fromUser = fromUser;
    }

    public Account getToUser() {
        return toUser;
    }

    public void setToUser(Account toUser) {
        this.toUser = toUser;
    }
}