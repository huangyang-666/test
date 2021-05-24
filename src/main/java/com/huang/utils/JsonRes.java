package com.huang.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonRes {
    private String state;
    private String errorCode;
    private String errorMessage;
    private String information;      //如果我需要加入种类的话，怎么去操作?
}
