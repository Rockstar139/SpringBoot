package com.praveen.journalApp.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.praveen.journalApp.entity.User;

public class UserRepositoryImpl {

    @Autowired
    private MongoTemplate mongoTemplate;

    // public List<User> getUserForSA() {
    //     Query query = new Query();
    //     query.addCriteria(Criteria.where("sentimentAnalysis").is(true));
    //     query.addCriteria(Criteria.where("email").exists(true).ne(null).ne(""));
    //     List<User> users = mongoTemplate.find(query, User.class);
    //     return users;
    // }

    public List<User> getUserForSA() {
        Query query = new Query(
                Criteria.where("sentimentAnalysis").is(true)
                        .and("email").regex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"));
        List<User> users = mongoTemplate.find(query, User.class);
        return users;
    }
}
