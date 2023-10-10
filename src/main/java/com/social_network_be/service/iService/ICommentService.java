package com.social_network_be.service.iService;

import com.social_network_be.model.Comment;


public interface ICommentService extends IService<Comment>{
    void deleteByPostId(int postId);
}
