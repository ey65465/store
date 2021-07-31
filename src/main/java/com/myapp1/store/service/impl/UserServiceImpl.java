package com.myapp1.store.service.impl;

import com.myapp1.store.mapper.UserMapper;
import com.myapp1.store.pojo.User;
import com.myapp1.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public void add(User user) {
        userMapper.add(user);
    }

    @Override
    public void delete(int id) {
        userMapper.delete(id);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public User getById(int id) {
        return userMapper.getById(id);
    }

    @Override
    public List<User> list() {
        return userMapper.list();
    }

    @Override
    public User getByName(String name) {
        return userMapper.getByName(name);
    }

    @Override
    public List<User> listByActor(String actor) {
        return userMapper.listByActor(actor);
    }
}
