package com.social_network_be.service.iService;

import com.social_network_be.model.Likes;
import com.social_network_be.model.Post;

public interface ILikeService extends IService<Likes>{
    int countByPostId(Post post);
}
