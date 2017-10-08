package com.ws.spring.dao;

import com.ws.spring.entity.SysRole;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ISysRoleDao {

    @Select("select t.id,t.available,t.description,t.role from sys_role t, sys_user_role u where t.id=u.role_id and t.id=#{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "available", column = "available"),
            @Result(property = "description", column = "description"),
            @Result(property = "role", column = "role"),
            @Result(property = "userInfoList", column = "uid",
            many = @Many(
                    select = "com.ws.spring.dao.IUserInfoDao.getUserById",
                    fetchType = FetchType.LAZY
            )),
    })
    SysRole getSysRoleUserById(Integer id);

    @Select("select * from sys_role where id=#{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "available", column = "available"),
            @Result(property = "description", column = "description"),
            @Result(property = "role", column = "role"),
    })
    SysRole getSysRoleById(Integer id);

    @Select("select * from sys_role")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "available", column = "available"),
            @Result(property = "description", column = "description"),
            @Result(property = "role", column = "role"),
    })
    List<SysRole> getAllRoles();

    /**
     * 通过用户id查询角色信息
     * @param uid  注意这里查询结果为两个表的全集，并不是单个表
     * @return
     */
    @Select("select * from sys_role t, sys_user_role u where t.id=u.role_id and u.uid=#{uid}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "available", column = "available"),
            @Result(property = "description", column = "description"),
            @Result(property = "role", column = "role"),
            @Result(property = "userInfoList", column = "uid",
                    many = @Many(
                            select = "com.ws.spring.dao.IUserInfoDao.getUserById",
                            fetchType = FetchType.EAGER
                    )),
    })
    SysRole getSysRoleByUid(Integer uid);

    @Select("select * from sys_role t where t.id in (select role_id from sys_user_role where uid= #{uid}) ")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "available", column = "available"),
            @Result(property = "description", column = "description"),
            @Result(property = "role", column = "role"),
            @Result(property = "sysPermissionList", column = "id",
                    many = @Many(
                            select = "com.ws.spring.dao.ISysPermissionDao.getPermissionsByRoleId",
                            fetchType = FetchType.EAGER
                    ))
    })
    SysRole getRolePermissionByUid(Integer uid);

    @Select("select * from sys_role t, sys_user_role u where t.id=u.role_id")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "available", column = "available"),
            @Result(property = "description", column = "description"),
            @Result(property = "role", column = "role"),
            @Result(property = "userInfoList", column = "uid",
                    many = @Many(
                            select = "com.ws.spring.dao.IUserInfoDao.getUserById",
                            fetchType = FetchType.EAGER
                    )),
    })
    List<SysRole> getRoleUserInfo();

    @Select("select * from sys_role t , sys_role_permission u where u.role_id = t.id")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "available", column = "available"),
            @Result(property = "description", column = "description"),
            @Result(property = "role", column = "role"),
            @Result(property = "sysPermissionList", column = "permission_id",
                    many = @Many(
                            select = "com.ws.spring.dao.ISysPermissionDao.getPermissionById",
                            fetchType = FetchType.EAGER
                    ))
    })
    List<SysRole> getRolePermissionInfo();
}
