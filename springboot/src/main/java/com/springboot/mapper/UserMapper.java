package com.springboot.mapper;

import com.springboot.pojo.User;
import org.apache.ibatis.annotations.Select;

/**
 * Created by mengtian on 2017/12/27
 */
public interface UserMapper {
    @Select("select * from user where username = #{username}")
    User selectUser(String username);
}
