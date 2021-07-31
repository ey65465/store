package com.myapp1.store.mapper;

import com.myapp1.store.pojo.City;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CityMapper {
    @Insert("insert into city (name, code) values (#{name}, #{code})")
    void add(City city);
    @Delete("delete from city where id=#{id}")
    void delete(int id);
    @Update("update city set name=#{name},code=#{code} where id=#{id}")
    void update(City city);
    @Select("select * from city where id=#{id}")
    City get(int id);
    @Select("select * from city")
    List<City> list();
    @Select("select * from city where name=#{name}")
    City listByName(String name);
}
