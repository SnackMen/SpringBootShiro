package com.ws.spring.realm;


import com.ws.spring.dao.IUserInfoDao;
import com.ws.spring.dao.ShiroSampleDao;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;


public class UserRealm extends AuthorizingRealm {



    @Autowired
    private ShiroSampleDao shiroSampleDao;

    @Autowired
    private IUserInfoDao iUserInfoDao;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String)super.getAvailablePrincipal(principalCollection);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Set<String> roles = shiroSampleDao.getRolesByUserName(username);
        authorizationInfo.setRoles(roles);
        roles.forEach(role-> {
            Set<String> permissions = this.shiroSampleDao.getPermissionsByRole(role);
            authorizationInfo.setStringPermissions(permissions);
        });
        return authorizationInfo;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //该token来自于filter中，可以在filter中重写tokern方法，使得其可以验证更多信息
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        System.out.println(token.isRememberMe());
        String username = token.getUsername();
        SecurityUtils.getSubject().getSession().setAttribute("username",username);
        String password = this.iUserInfoDao.getPasswordByUserName(username);
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
