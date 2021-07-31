package com.myapp1.store.mapper;

import com.myapp1.store.pojo.School;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SchoolMapper {
    @Insert("insert into school (name, address, city_id, openTime) values (#{name}, #{address}, #{city.id}, #{openTime})")
    void add(School school);
    @Delete("delete from school where id=#{id}")
    void delete(int id);
    @Update("update school set name=#{name}, address=#{address}, city_id=#{city.id}, openTime=#{openTime} where id=#{id}")
    void update(School school);
    @Select("select * from school where id=#{id}")
    School getById(int id);
    @Select("select * from school")
    List<School> list();
    @Select("select * from school where name=#{name}")
    School getByName(String name);
    @Select("select * from school where city_id=#{city.id}")
    List<School> listByCity(String city);
}
