package com.social_network_be.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.social_network_be.model.Account;
import com.social_network_be.model.Message;
import com.social_network_be.model.dto.MessageAllViewModel;
import com.social_network_be.model.dto.MessageCreateBindingModel;
import com.social_network_be.model.dto.MessageFriendsViewModel;
import com.social_network_be.model.dto.MessageServiceModel;
import com.social_network_be.service.iService.IAccountService;
import com.social_network_be.service.iService.IMessageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private SimpMessagingTemplate template;
    @Autowired
    private IMessageService messageService;
    @Autowired
    private IAccountService accountService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ObjectMapper objectMapper;
//    http://localhost:8080/message/all/{id}
//trong hàm getAllMessages @PathVariable int id sẽ là người bên kia nhắn
//    và @RequestBody Account principal sẽ là chủ thể của mình đang đăng nhập
    @PostMapping( "/all/{id}")
    public List<MessageAllViewModel> getAllMessages(@PathVariable int id ,@RequestBody Account principal) {
        String loggedInUsername = principal.getUsername();
        List<MessageServiceModel> messageServiceModels = messageService.getAllMessages(loggedInUsername, id);
            return messageServiceModels.stream()
                    .map(messageServiceModel -> modelMapper.map(messageServiceModel, MessageAllViewModel.class))
                    .collect(Collectors.toList());
    }
    @GetMapping("/allFriend/{id}")
    public List<Message> getAllChatFriends(@PathVariable int id){
        return messageService.initialStateAllChatFriends(id);
    }

    @PostMapping( "/friend")
    public List<MessageFriendsViewModel> getAllFriendMessages(@RequestBody Account principal) {
        Account accountPrincipal = accountService.findByUsername(principal.getUsername());
        String loggedInUsername = accountPrincipal.getUsername();
        return messageService.getAllFriendMessages(loggedInUsername);
    }
//    gửi tin nhắn đến một người dùng cụ thể trong đó messageCreateBindingModel sẽ là nội dung tin nhắn
//    trong đó bao gồm id của người nhận và content gửi đi
//    và principal sẽ là account đang đăng nhập và máp MessageServiceModel sang message và lưu vào database ok
    @MessageMapping("/message")
    public void createPrivateChatMessages(@RequestBody MessageCreateBindingModel messageCreateBindingModel, Account principal) throws Exception {
        MessageServiceModel message = messageService.createMessage(messageCreateBindingModel, principal.getUsername());
        MessageAllViewModel messageAllViewModel = this.modelMapper.map(message, MessageAllViewModel.class);
        if (messageAllViewModel != null) {
            String response = objectMapper.writeValueAsString(messageAllViewModel);
            template.convertAndSend("/user/" + message.getToUser().getUsername() + "/queue/position-update", response);
            template.convertAndSend("/user/" + message.getFromUser().getUsername() + "/queue/position-update", response);
            return;
        }
        throw new Exception("Error Create Message !");
    }
}