package com.excel.core.bean;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("userplus")
public class UserPlus {
    private Integer id;
    private String name;
    private Integer age;

    @TableField(exist = false)
    private String state;
}
