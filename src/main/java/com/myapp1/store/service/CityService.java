package com.myapp1.store.service;

import com.myapp1.store.pojo.City;

import java.util.List;

public interface CityService {

    void add(City city);

    void delete(int id);

    void update(City city);

    City get(int id);

    List<City> list();

    City listByName(String name);
}
