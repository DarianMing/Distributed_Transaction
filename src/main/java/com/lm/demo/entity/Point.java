package com.lm.demo.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Point {

    private String id;
    private String userId;
    private int amount;

}
