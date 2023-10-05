package com.social_network_be.service.impl;

import com.social_network_be.model.Comment;
import com.social_network_be.repository.ICommentRepo;
import com.social_network_be.service.iService.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
<<<<<<< HEAD
@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    ICommentRepo commentRepo;
=======

@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    private ICommentRepo commentRepo;

>>>>>>> b9b38257503e2f2dcd1fff36d68eb0ea50ec5b84
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
<<<<<<< HEAD
        return commentRepo.findAll();
    }
}
=======
        return (List<Comment>) commentRepo.findAll();
    }
}
>>>>>>> b9b38257503e2f2dcd1fff36d68eb0ea50ec5b84
