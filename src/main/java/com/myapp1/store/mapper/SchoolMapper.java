package com.myapp1.store.mapper;

import com.myapp1.store.pojo.School;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SchoolMapper {
    @Insert("insert into school (name, address, city_id, openDate) values (#{name}, #{address}, #{city.id}, #{openDate})")
    void add(School school);
    @Delete("delete from school where id=#{id}")
    void delete(int id);
    @Update("update school set name=#{name}, address=#{address}, city_id=#{city.id}, openDate=#{openDate} where id=#{id}")
    void update(School school);
    @Select("select * from school where id=#{id}")
    @Results(
            @Result(property = "city", column = "city_id",
                    one=@One(select = "com.myapp1.store.mapper.CityMapper.get"))
    )
    School getById(int id);
    @Select("select * from school")
    @Results(
            @Result(property = "city", column = "city_id",
                    one=@One(select = "com.myapp1.store.mapper.CityMapper.get"))
    )
    List<School> list();
    @Select("select * from school where name=#{name}")
    @Results(
            @Result(property = "city", column = "city_id",
                    one=@One(select = "com.myapp1.store.mapper.CityMapper.get"))
    )
    School getByName(String name);
    @Select("select * from school where city_id=#{city.id}")
    @Results(
            @Result(property = "city", column = "city_id",
                    one=@One(select = "com.myapp1.store.mapper.CityMapper.get"))
    )
    List<School> listByCity(String city);
}
