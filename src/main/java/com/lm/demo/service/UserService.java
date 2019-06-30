package com.lm.demo.service;

import com.alibaba.fastjson.JSON;
import com.lm.demo.dao.UserDao;
import com.lm.demo.entity.Event;
import com.lm.demo.entity.Point;
import com.lm.demo.enums.EventProcess;
import com.lm.demo.enums.EventType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    private final UserEventService userEventService;

    @Transactional
    public void newUser (String userName , Integer pointAmount) {
        String userId = userDao.insert(userName);

        Point point = new Point();
        String id = UUID.randomUUID().toString().replace("-","");
        point.setUserId(userId).setAmount(pointAmount).setId(id);

        Event event = new Event();
        event.setType(EventType.NEW_USER.getValue())
                .setProcess(EventProcess.NEW.getValue())
                .setProcess(JSON.toJSONString(point));
        userEventService.newEvent(event);
    }

}
