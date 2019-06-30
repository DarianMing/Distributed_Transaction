package com.lm.demo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EventProcess implements BaseEnum{
    NEW("NEW" , "新建"),
    PUBLISHED("PUBLISHED" , "已发布"),
    PROCESSED("PROCESSED" , "已完成");

    private String value;
    private String desc;

}
