package com.myapp1.store;

import com.myapp1.store.pojo.User;
import com.myapp1.store.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class StoreApplicationTests {
    @Autowired
    UserService userService;
    @Test
    void contextLoads() {
        User user = new User();
        user.setName("xmw");
        user.setPassword("123");
        user.setActor("student");
        user.setCreateDate(new Date());
        userService.add(user);
    }

}
