package com.social_network_be.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Account followedAccount;
    @ManyToOne
    private Account account;

    public Follow(Account followedAccount, Account account) {
        this.followedAccount = followedAccount;
        this.account = account;
    }
}
