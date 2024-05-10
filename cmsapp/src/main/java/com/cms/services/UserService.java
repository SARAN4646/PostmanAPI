package com.cms.services;

import java.util.HashMap;
import java.util.Map;

import com.cms.models.User;

public class UserService {
    private Map<Integer, User> users = new HashMap<>();
    private int nextUserId = 1;
    
    public User getUser(int userId) {
        return users.get(userId);
    }
    
    public Map<Integer, User> getAllUsers() {
        return users;
    }
    
    public void addUser(User user) {
        user.setId(nextUserId++);
        users.put(user.getId(), user);
    }
}

