package com.haliri.israj.service;

import com.haliri.israj.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Israj PC on 10/19/2016.
 */
public interface UserRepository extends MongoRepository<User, String> {
    public User findByUsername(String username);
}

