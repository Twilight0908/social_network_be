package com.social_network_be.repository;

import com.social_network_be.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStatusRepo extends JpaRepository<Status , Integer> {
}
