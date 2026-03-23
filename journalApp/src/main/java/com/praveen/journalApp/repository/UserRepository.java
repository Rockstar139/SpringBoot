package com.praveen.journalApp.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.praveen.journalApp.entity.User;

public interface UserRepository extends MongoRepository<User, ObjectId>{
    User findByUserName(String userName);

}
