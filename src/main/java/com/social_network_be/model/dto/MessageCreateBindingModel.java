package com.social_network_be.model.dto;

import com.sun.istack.NotNull;

public class MessageCreateBindingModel {
    private int toUserId;
    private String content;

    public MessageCreateBindingModel() {
    }

    @NotNull
    public int getToUserId() {
        return this.toUserId;
    }

    public void setToUserId(int toUserId) {
        this.toUserId = toUserId;
    }

    @NotNull
    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}