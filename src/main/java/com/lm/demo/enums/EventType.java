package com.lm.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum  EventType {

    NEW_USER("NEW_USER" , "新增用户"),
    NEW_POINT("NEW_POINT" , "新增积分");

    private String value;
    private String desc;

}
