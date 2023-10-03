package com.social_network_be.model.dto;

import com.social_network_be.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountToken {
    private int id;
    private String lastName;
    private boolean online;
    private boolean ban;
    private String avatar;
    private String thumbnail;
    private String token;
    private Role role;
}
