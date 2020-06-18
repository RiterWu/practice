package com.huiyu.demo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class User {
    /**
     * 手机号
     */
    private String phone;
    /**
     * 客户编号
     */
    private String customerCode;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 是否可用 true-可用状态 false-不可用
     */
    private Boolean enabled;
    /**
     * 是否已删除 true-已删除 false-未删除
     */
    private Boolean deleted;
}
