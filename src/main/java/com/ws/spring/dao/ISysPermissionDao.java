package com.ws.spring.dao;

import com.ws.spring.entity.SysPermission;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface ISysPermissionDao {


    @Select("select * from sys_permission where id=#{id}")
    @Results({
            @Result(property = "parentId",column = "parent_id"),
            @Result(property = "parentIds",column = "parent_ids"),
            @Result(property = "resourceType",column = "resource_type")
    })
    SysPermission getPermissionById(Integer id);

    @Select("select * from sys_permission t, sys_role_permission u where t.id=u.permission_id and t.id=#{id}")
    @Results({
            @Result(property = "parentId",column = "parent_id"),
            @Result(property = "parentIds",column = "parent_ids"),
            @Result(property = "resourceType",column = "resource_type"),
            @Result(property = "sysRoleList", column = "u.role_id",
            many = @Many(
                    select = "com.ws.spring.dao.ISysRoleDao.getSysRoleById",
                    fetchType = FetchType.LAZY
            ))
    })
    List<SysPermission> getPermissionRoleById(Integer id);

    @Select("select * from sys_permission")
    @Results({
            @Result(property = "parentId",column = "parent_id"),
            @Result(property = "parentIds",column = "parent_ids"),
            @Result(property = "resourceType",column = "resource_type")
    })
    List<SysPermission> getAllPermissions();

    @Select("select * from sys_permission where id in (select permission_id from sys_role_permission where role_id=#{roleId})")
    @Results({
            @Result(property = "parentId",column = "parent_id"),
            @Result(property = "parentIds",column = "parent_ids"),
            @Result(property = "resourceType",column = "resource_type")
    })
    List<SysPermission> getPermissionsByRoleId(Integer roleId);
}
