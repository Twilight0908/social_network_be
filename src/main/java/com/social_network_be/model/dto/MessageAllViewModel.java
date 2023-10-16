package com.social_network_be.model.dto;
import lombok.Data;
import java.time.LocalDateTime;
@Data
public class MessageAllViewModel {
    private String id;
    private int fromUserId;
    private String fromUserFirstName;
    private String fromUserLastName;
    private String fromUserProfilePicUrl;
    private String content;
    private LocalDateTime time;
}