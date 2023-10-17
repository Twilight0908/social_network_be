package com.social_network_be.model.dto;

import com.social_network_be.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountToken {
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String phone;
    private LocalDate birthday;
    private String avatar;
    private String address;
    private String thumbnail;
    private LocalDateTime createAt;
    private boolean gender;
    private boolean ban;
    private boolean online;
    private String token;
    private Role role;
}
