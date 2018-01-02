package com.springboot.pojo;

import java.util.Date;

import lombok.*;

/**
 * @Title: TODO (用一句话描述该文件做什么)
 * @Package com.adult.pojo
 * @Description: TODO (用一句话描述该文件做什么)
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
    private Date createTime;
    private Date updateTime;
}
