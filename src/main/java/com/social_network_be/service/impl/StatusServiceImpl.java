package com.social_network_be.service.impl;

import com.social_network_be.model.Status;
import com.social_network_be.repository.IStatusRepo;
import com.social_network_be.service.iService.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StatusServiceImpl implements IStatusService {
   @Autowired
    IStatusRepo statusRepo;
    @Override
    public Status save(Status status) {
        return statusRepo.save(status);
    }

    @Override
    public Status edit(Status status) {
        return statusRepo.save(status);
    }

    @Override
    public void delete(int id) {
          statusRepo.deleteById(id);
    }

    @Override
    public Status findById(int id) {
        return statusRepo.findById(id).get();
    }

    @Override
    public List<Status> getAll() {
        return statusRepo.findAll();
    }
}