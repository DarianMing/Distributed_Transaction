package com.lm.demo.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Event {

    private int id;
    private String type; //事件类型
    private String process; //表示事件进行到了那个环节
    private String content; //事件包含的内容

}
