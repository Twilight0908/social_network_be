package com.social_network_be.service.impl;

import com.social_network_be.model.Account;
import com.social_network_be.model.Message;
import com.social_network_be.model.Relationship;
import com.social_network_be.model.dto.MessageCreateBindingModel;
import com.social_network_be.model.dto.MessageFriendsViewModel;
import com.social_network_be.model.dto.MessageServiceModel;
import com.social_network_be.repository.IAccountRepo;
import com.social_network_be.repository.MessageRepository;
import com.social_network_be.repository.RelationshipRepository;
import com.social_network_be.service.iService.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class MessageServiceImpl implements IMessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private RelationshipRepository relationshipRepository;
    @Autowired
    private IAccountRepo accountRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MessageServiceModel createMessage(MessageCreateBindingModel messageCreateBindingModel, String loggedInUsername) throws Exception {
        Account fromUser = accountRepo.findByUsername(loggedInUsername);
        Optional<Account> toUser = accountRepo.findById(messageCreateBindingModel.getToUserId());
        Relationship relationship = relationshipRepository.findRelationshipWithFriendWithStatus(fromUser.getId(),toUser.get().getId(),1);
        MessageServiceModel messageServiceModel = new MessageServiceModel();
        messageServiceModel.setContent(messageCreateBindingModel.getContent());
        messageServiceModel.setFromUser(fromUser);
        messageServiceModel.setToUser(toUser.get());
        messageServiceModel.setRelationship(relationship);
        messageServiceModel.setTime(LocalDateTime.now());
        Message savedMessage = messageRepository.save(modelMapper.map(messageServiceModel,Message.class));
        if(savedMessage != null){
          return modelMapper.map(savedMessage, MessageServiceModel.class);
        }else {
            throw new Exception("Server Error");
        }
    }

    @Override
    public List<MessageServiceModel> getAllMessages(String loggedInUsername, int chatUserId) {
        Account loggedInUser = accountRepo.findByUsername(loggedInUsername);
        Optional<Account> chatUser = accountRepo.findById(chatUserId);
        List<Message> allMessagesBetweenTwoUsers = messageRepository.findAllMessagesBetweenTwoUsers(loggedInUser.getId() , chatUser.get().getId());
        updateMessageStatus(loggedInUser.getId(),chatUserId);
        List<MessageServiceModel> messageServiceModels = allMessagesBetweenTwoUsers.stream().map(message -> modelMapper.map(message , MessageServiceModel.class)).collect(Collectors.toList());
       return allMessagesBetweenTwoUsers.stream().map(message -> modelMapper.map(message , MessageServiceModel.class)).collect(Collectors.toList());
    }

//    @Override
//    public List<MessageFriendsViewModel> getAllFriendMessages(String loggedInUsername) {
//        Account loggedInUser = accountRepo.findByUsername(loggedInUsername);
//        List<Message> allUnreadMessages = messageRepository.getAllUnreadMessages(loggedInUser.getId());
//        List<MessageServiceModel> messageServiceModels = allUnreadMessages.stream().map(message -> modelMapper.map(message , MessageServiceModel.class)).collect(Collectors.toList());
//        List<MessageServiceModel> allFriendsMessages =  messageServiceModels.stream()
//                .filter(message -> message.getRelationship().getStatus() == 1)
//                .collect(Collectors.toList());
//        return mapToMessageFriendsViewModel(loggedInUser.getId(), allFriendsMessages);
//    }

    @Override
    public List<MessageFriendsViewModel> getAllFriendMessages(String loggedInUsername) {
        Account loggedInUser = accountRepo.findByUsername(loggedInUsername);
        List<Message> allUnreadMessages = new ArrayList<>();
        List<Message> messages1 = new ArrayList<>();
        List<Message> messages2 = new ArrayList<>();
        List<Message> messageList = messageRepository.findAll();
        for (int i = 0; i < messageList.size(); i++) {
            if(messageList.get(i).getToUser().getId() == loggedInUser.getId()){
                messages1.add(messageList.get(i));
            }
        }


        List<MessageServiceModel> messageServiceModels = allUnreadMessages.stream().map(message -> modelMapper.map(message , MessageServiceModel.class)).collect(Collectors.toList());
        List<MessageServiceModel> allFriendsMessages =  messageServiceModels.stream()
                .filter(message -> message.getRelationship().getStatus() == 1)
                .collect(Collectors.toList());
        return mapToMessageFriendsViewModel(loggedInUser.getId(), allFriendsMessages);
    }

    private List<MessageFriendsViewModel> mapToMessageFriendsViewModel(int loggedInUserId, List<MessageServiceModel> allUnreadMessages) {
        List<Object[]> countOfUnreadMessagesByFromUser = messageRepository.getCountOfUnreadMessagesByFromUser(loggedInUserId);

        return allUnreadMessages.stream()
                .map(messageServiceModel -> {
                    MessageFriendsViewModel unreadViewModel = modelMapper.map(messageServiceModel, MessageFriendsViewModel.class);
                    Object[] objects = countOfUnreadMessagesByFromUser.stream()
                            .filter(element -> element[0].equals(unreadViewModel.getFromUserId()))
                            .findFirst().orElse(null);

                    if(objects != null){
                        unreadViewModel.setCount(Integer.valueOf(objects[1].toString()));
                    }else{
                        unreadViewModel.setCount(0);
                    }

                    return unreadViewModel;
                })
                .collect(Collectors.toList());
    }
    private void updateMessageStatus(int loggedInUserId, int chatUserId) {
        messageRepository.updateStatusFromReadMessages(loggedInUserId, chatUserId);
    }
}