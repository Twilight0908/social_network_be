package com.social_network_be.service.iService;

import com.social_network_be.model.Like;
import com.social_network_be.model.Post;

public interface ILikeService extends IService<Like>{
    int countByPostId(Post post);
}
