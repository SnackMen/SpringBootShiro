package com.ws.spring.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Set;

@Repository
public interface ShiroSampleDao {

    @Select("select role from sys_role where id in (select role_id from sys_user_role where uid in " +
            "(select uid from user_info where username = #{username}))")
    Set<String> getRolesByUserName(String username);


    @Select("select permission from sys_permission where id in (" +
            "select permission_id from sys_role_permission where role_id in (" +
            "select id from sys_role where role=#{role}))")
    Set<String> getPermissionsByRole(String role);



}
