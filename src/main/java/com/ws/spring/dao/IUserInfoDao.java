package com.ws.spring.dao;

import com.ws.spring.entity.UserInfo;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IUserInfoDao {

    @Select("select password from user_info where username=#{username}")
    String getPasswordByUserName(String username);

    @Results({
            @Result(property = "id", column = "uid"),
            @Result(property = "username", column = "username"),
            @Result(property = "name", column = "name"),
            @Result(property = "password", column = "password"),
            @Result(property = "salt", column = "salt"),
            @Result(property = "state", column = "state")
    })
    @Select("select * from user_info")
    List<UserInfo> getAll();

    @Results({
            @Result(property = "id", column = "uid"),
            @Result(property = "username", column = "username"),
            @Result(property = "name", column = "name"),
            @Result(property = "password", column = "password"),
            @Result(property = "salt", column = "salt"),
            @Result(property = "state", column = "state")
    })
    @Select("select * from user_info where uid=#{id}")
    UserInfo getUserById(Integer id);

    /**
     * 通过用户名查询用户id
     */
    @Results({
            @Result(property = "id", column = "uid")
    })
    @Select("select uid from user_info where username=#{username}")
    Integer getIdByUsername(String username);


}
