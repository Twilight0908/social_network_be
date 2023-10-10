package com.social_network_be.service.iService;

import com.social_network_be.model.Account;
import com.social_network_be.model.Like;
import com.social_network_be.model.Post;

import java.util.List;

public interface ILikeService extends IService<Like>{
//    List<Like> findAllByAccountAAndPost(Account account, Post post);
void deleteByPostId(int postId);
}
