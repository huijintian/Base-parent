package com.springboot.pojo;

import java.util.Date;

import lombok.*;

/**
 * @Author auto generated
 * @Date 2017-12-27 21:57:45
 */
@Getter
@Setter
@ToString
public class User /* extends BaseDomain */ {
    private Long id;
    private String username;
    private String userPwd;
    private String salt;
    private Date createTime;
    private Date updateTime;
}
