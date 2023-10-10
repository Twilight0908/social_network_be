package com.social_network_be.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.social_network_be.model.Like;
import com.social_network_be.service.iService.ILikeService;
import com.social_network_be.validations.successResponse.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static com.social_network_be.validations.constants.ResponseMessageConstants.SUCCESSFUL_LIKE_POST_MESSAGE;

@RestController
@CrossOrigin("*")
@RequestMapping("/apiLike")
public class LikeController {
    @Autowired
    ILikeService likeService;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    SimpMessagingTemplate template;
    @PostMapping
    @SendTo("/topic/like")
    public ResponseEntity<?> createLike(@RequestBody Like like) throws JsonProcessingException {
        SuccessResponse successResponse = new SuccessResponse(LocalDateTime.now(), SUCCESSFUL_LIKE_POST_MESSAGE, "", true);
        likeService.save(like);
        template.convertAndSend("/topic/like", like);
        return new ResponseEntity<>(objectMapper.writeValueAsString(successResponse), HttpStatus.OK);
    }
    @PostMapping("/{id}")
    @SendTo("/topic/deleteLike")
    public ResponseEntity<?> deleteLike(@PathVariable int id) throws JsonProcessingException {
        likeService.delete(id);
        // Gửi thông điệp WebSocket đến "/topic/like" để thông báo xóa like
        template.convertAndSend("/topic/deleteLike", "Like with id " + id + " has been deleted");
        SuccessResponse successResponse = new SuccessResponse(LocalDateTime.now(), SUCCESSFUL_LIKE_POST_MESSAGE, "", true);
        return new ResponseEntity<>(objectMapper.writeValueAsString(successResponse), HttpStatus.OK);
    }
    @GetMapping
    @MessageMapping("/like")
    public List<Like> getAllLike(@Payload Like like){
//      phương thức @MessageMapping sử lý dữ liệu nhận về khi phía bên kia nhắn tin cho mình
        return likeService.getAll();
    }

    @SendTo("/topic/like")
    public Like loadLike(@Payload Like like){
//        hàm này sẽ là hàm trả về một list like với những người đang theo dõi /topic/like
//         đại loại là trả dữ liệu về cho người đang dùng phía bên kia

        return like;
    }
}