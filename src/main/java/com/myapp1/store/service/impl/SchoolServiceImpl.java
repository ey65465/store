package com.myapp1.store.service.impl;

import com.myapp1.store.mapper.SchoolMapper;
import com.myapp1.store.pojo.School;
import com.myapp1.store.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    SchoolMapper schoolMapper;

    @Override
    public void add(School school) {
        schoolMapper.add(school);
    }

    @Override
    public void delete(int id) {
        schoolMapper.delete(id);
    }

    @Override
    public void update(School school) {
        schoolMapper.update(school);
    }

    @Override
    public School getById(int id) {
        return schoolMapper.getById(id);
    }

    @Override
    public List<School> list() {
        return schoolMapper.list();
    }

    @Override
    public School getByName(String name) {
        return schoolMapper.getByName(name);
    }

    @Override
    public List<School> listByCity(String city) {
        return schoolMapper.listByCity(city);
    }
}
