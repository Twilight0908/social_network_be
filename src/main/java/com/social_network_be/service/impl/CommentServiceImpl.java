package com.social_network_be.service.impl;


import com.social_network_be.model.Comment;
import com.social_network_be.repository.ICommentRepo;
import com.social_network_be.service.iService.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    ICommentRepo commentRepo;

    @Override
    public Comment save(Comment comment) {
        return commentRepo.save(comment);
    }

    @Override
    public Comment edit(Comment comment) {
        return commentRepo.save(comment);
    }

    @Override
    public void delete(int id) {
         commentRepo.deleteById(id);
    }

    @Override
    public Comment findById(int id) {
        return commentRepo.findById(id).get();
    }

    @Override
    public List<Comment> getAll() {
        return commentRepo.findAll();
    }
}
