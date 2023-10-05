package com.social_network_be.service.iService;

<<<<<<< HEAD
import com.social_network_be.model.Like;

public interface ILikeService extends IService<Like>{
=======
import com.social_network_be.model.Likes;
import com.social_network_be.model.Post;

public interface ILikeService extends IService<Likes>{
    int countByPostId(Post post);
>>>>>>> b9b38257503e2f2dcd1fff36d68eb0ea50ec5b84
}
