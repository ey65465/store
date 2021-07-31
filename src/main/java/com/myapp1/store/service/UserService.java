package com.myapp1.store.service;

import com.myapp1.store.pojo.User;

import java.util.List;

public interface UserService {

    void add(User user);

    void delete(int id);

    void update(User user);

    User getById(int id);

    List<User> list();

    User getByName(String name);

    List<User> listByActor(String actor);
}
