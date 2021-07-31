package com.myapp1.store.service.impl;

import com.myapp1.store.mapper.CityMapper;
import com.myapp1.store.pojo.City;
import com.myapp1.store.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityMapper cityMapper;

    @Override
    public void add(City city) {
        cityMapper.add(city);
    }

    @Override
    public void delete(int id) {
        cityMapper.delete(id);
    }

    @Override
    public void update(City city) {
        cityMapper.update(city);
    }

    @Override
    public City get(int id) {
        return cityMapper.get(id);
    }

    @Override
    public List<City> list() {
        return cityMapper.list();
    }

    @Override
    public City listByName(String name) {
        return cityMapper.listByName(name);
    }
}
