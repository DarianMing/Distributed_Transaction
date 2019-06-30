package com.lm.demo.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lm.demo.entity.Event;
import com.lm.demo.mapper.EventMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserEventDao {

    private final EventMapper eventMapper;

    public Integer insert (Event event) {
        return eventMapper.insert(event);
    }

    public Integer update (Event event) {
        return eventMapper.updateById(event);
    }

    public List<Event> getByProcess (String process) {
        List<Event> result = eventMapper.selectList(new QueryWrapper<Event>()
                .eq("process", process));
        return CollectionUtils.isEmpty(result) ? new ArrayList<>() : result;
    }

}
