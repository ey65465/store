package com.myapp1.store.service;

import com.myapp1.store.pojo.School;

import java.util.List;

public interface SchoolService {
    void add(School school);
    void delete(int id);
    void update(School school);
    School getById(int id);
    List<School> list();
    School getByName(String name);
    List<School> listByCity(String city);
}
