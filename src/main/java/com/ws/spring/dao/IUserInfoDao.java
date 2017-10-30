package com.ws.spring.dao;

import com.ws.spring.entity.UserInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
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
            @Result(property = "state", column = "state"),
            @Result(property = "registerTime", column = "regist_time"),
            @Result(property = "lastLoginTime", column = "last_login")
    })
    @Select("select * from user_info")
    List<UserInfo> getAll();

    @Results({
            @Result(property = "id", column = "uid"),
            @Result(property = "username", column = "username"),
            @Result(property = "name", column = "name"),
            @Result(property = "password", column = "password"),
            @Result(property = "salt", column = "salt"),
            @Result(property = "state", column = "state"),
            @Result(property = "registerTime", column = "regist_time"),
            @Result(property = "lastLoginTime", column = "last_login")
    })
    @Select("select * from user_info where uid=#{id}")
    UserInfo getUserById(Integer id);

    /**
     * 通过用户名查询用户id
     */
    @Results({
            @Result(property = "id", column = "uid"),
            @Result(property = "registerTime", column = "regist_time"),
            @Result(property = "lastLoginTime", column = "last_login")
    })
    @Select("select uid from user_info where username=#{username}")
    Integer getIdByUsername(String username);


    @Insert("insert into user_info(username, name, password, salt, state, email) values (#{username}, #{name}, #{password}, #{salt}, #{state}, #{email})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Integer registerMessage(UserInfo userInfo);

    @Update("update user_info set state = 1 where username = #{username}")
    Integer activateAccount(String username);

    @Results({
            @Result(property = "id", column = "uid"),
            @Result(property = "username", column = "username"),
            @Result(property = "name", column = "name"),
            @Result(property = "password", column = "password"),
            @Result(property = "salt", column = "salt"),
            @Result(property = "state", column = "state"),
            @Result(property = "registerTime", column = "regist_time"),
            @Result(property = "lastLoginTime", column = "last_login")
    })
    @Select("select * from user_info where username=#{username}")
    UserInfo getUserInfoByUsername(String username);

    @Results({
            @Result(property = "id", column = "uid"),
            @Result(property = "username", column = "username"),
            @Result(property = "name", column = "name"),
            @Result(property = "password", column = "password"),
            @Result(property = "salt", column = "salt"),
            @Result(property = "state", column = "state"),
            @Result(property = "registerTime", column = "regist_time"),
            @Result(property = "lastLoginTime", column = "last_login"),
            @Result(property = "sysRole",column = "role_id",
            many = @Many(
                    select = "com.ws.spring.dao.ISysRoleDao.getSysRoleById",
                    fetchType = FetchType.LAZY
            ))
    })
    @Select("select * from user_info t, sys_user_role u where t.uid=u.role_id and online=#{online}")
    List<UserInfo> getUserInfoListByOnline(String online);

}
