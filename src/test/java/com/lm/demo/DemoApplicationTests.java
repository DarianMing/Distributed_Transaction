package com.lm.demo;

import com.lm.demo.entity.User;
import com.lm.demo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testUserMapper () {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    public void contextLoads() {
    }

}
