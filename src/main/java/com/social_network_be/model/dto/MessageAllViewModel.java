package com.social_network_be.model.dto;
import com.social_network_be.model.Account;
import lombok.Data;
import java.time.LocalDateTime;
@Data
public class MessageAllViewModel {
    private String id;
    private int fromUserId;
    private String fromUserFirstName;
    private String fromUserLastName;
    private String fromUserAvatar;
    private String content;
    private LocalDateTime time;
    private int toUserId;
    private Account principal;
}