package com.lm.demo.service;

import com.lm.demo.dao.UserEventDao;
import com.lm.demo.entity.Event;
import com.lm.demo.enums.EventProcess;
import com.lm.demo.enums.EventType;
import com.lm.demo.event.UserEventSend;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

@Service
@RequiredArgsConstructor
public class UserEventService {

    private final UserEventDao userEventDao;

    private final UserEventSend userEventSend;

    public void newEvent (Event event) {
        checkNotNull(event);
        userEventDao.insert(event);
    }

    public List<Event> getNewEventList () {
        return userEventDao.getByProcess(EventProcess.NEW.getValue());
    }

    public void executeEvent (Event event) {
        checkNotNull(event);
        if (event.getProcess().equals(EventProcess.NEW.getValue())
                && event.getType().equals(EventType.NEW_USER.getValue())) {
            String messageContent = event.getContent();
            userEventSend.sendMsg(messageContent);
        }
        event.setProcess(EventProcess.PUBLISHED.getValue());
        userEventDao.update(event);
    }



}
