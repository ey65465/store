package com.myapp1.store.mapper;

import com.myapp1.store.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Insert("insert into user (name, password, actor, createDate) values (#{name}, #{password}, #{actor}, #{createDate})")
    void add(User user);
    @Delete("delete from user where id=#{id}")
    void delete(int id);
    @Update("update user set name=#{name}, password=#{password}, actor=#{actor} where id=#{id}")
    void update(User user);
    @Select("select * from user where id=#{id}")
    User getById(int id);
    @Select("select * from user")
    List<User> list();
    @Select("select * from user where name=#{name}")
    User getByName(String name);
    @Select("select * from user where actor=#{actor}")
    List<User> listByActor(String actor);
}
