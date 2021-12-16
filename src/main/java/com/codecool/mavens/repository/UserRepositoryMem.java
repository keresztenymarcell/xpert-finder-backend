package com.codecool.mavens.repository;


import com.codecool.mavens.model.entity.User;

import java.util.ArrayList;
import java.util.List;


public class UserRepositoryMem {
    private List<User> users = new ArrayList<>();

    public void save(User user) {
        users.add(user);
    }

    public List<User> getAll() {
        return users;
    }
}
