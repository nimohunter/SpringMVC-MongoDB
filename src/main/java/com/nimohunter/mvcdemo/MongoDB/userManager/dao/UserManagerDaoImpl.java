package com.nimohunter.mvcdemo.MongoDB.userManager.dao;

import com.nimohunter.mvcdemo.MongoDB.userManager.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

/**
 * Created by nimohunter on 2017/6/14.
 * Contact me by nimohunter@gmail.com
 */

@Service
public class UserManagerDaoImpl implements UserManagerDao {

    @Autowired
    private MongoOperations mongoOperation;


    @Override
    public void save(User user) {
        mongoOperation.save(user);
    }

    @Override
    public User findUserByName(String name) {
        return (User) mongoOperation.findOne(new Query(Criteria.where("name").is(name)), User.class);
    }

    @Override
    public void removeUserByName(String name) {
        mongoOperation.findAndRemove(new Query(Criteria.where("name").is(name)), User.class);
    }
}
