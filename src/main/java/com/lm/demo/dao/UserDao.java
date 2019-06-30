package com.lm.demo.dao;

import com.lm.demo.entity.User;
import com.lm.demo.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserDao {

    private final UserMapper userMapper;

    public String insert (String userName) {
        String id = UUID.randomUUID().toString().replace("-","");
        User user = new User();
        user.setId(id).setUserName(userName);
        userMapper.insert(user);
        return id;
    }

}
