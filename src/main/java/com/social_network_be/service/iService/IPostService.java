package com.social_network_be.service.iService;

import com.social_network_be.model.Post;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPostService extends IService<Post>{
    List<Post> getAllByFollow(@Param("userId") int userId);
    List<Post> getAllByUserId(int userId);
}
