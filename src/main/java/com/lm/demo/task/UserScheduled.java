package com.lm.demo.task;

import com.lm.demo.entity.Event;
import com.lm.demo.service.UserEventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserScheduled {

    private final UserEventService userEventService;

    @Scheduled(cron = "*/5 * * * * *")
    public void executeEvent () {
        List<Event> newEventList = userEventService.getNewEventList();
        if (!CollectionUtils.isEmpty(newEventList)) {
            log.info("新建用户的事件记录总数:{}" , newEventList.size());
            newEventList.forEach(userEventService::executeEvent);
        } else {
            log.info("新建用户的事件记录总数:{}" , 0);
        }
    }

}
