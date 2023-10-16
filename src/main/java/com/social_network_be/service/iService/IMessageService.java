package com.social_network_be.service.iService;
import com.social_network_be.model.dto.MessageCreateBindingModel;
import com.social_network_be.model.dto.MessageFriendsViewModel;
import com.social_network_be.model.dto.MessageServiceModel;

import java.util.List;

public interface IMessageService {
    MessageServiceModel createMessage(MessageCreateBindingModel messageCreateBindingModel, String loggedInUsername) throws Exception;
    List<MessageServiceModel> getAllMessages(String loggedInUsername, int chatUserId);

    List<MessageFriendsViewModel> getAllFriendMessages(String loggedInUsername);
}
