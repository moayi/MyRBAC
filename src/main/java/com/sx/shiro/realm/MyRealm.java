package com.sx.shiro.realm;

import com.sx.entity.User;
import com.sx.service.PermissionServcie;
import com.sx.service.RoleService;
import com.sx.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashSet;
import java.util.List;

/**
 * moayi
 *
 * @create 2018-06-11 11:34
 **/
public class MyRealm  extends AuthorizingRealm {
    @Autowired
    private UserService  userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionServcie permissionServcie;
    /**
     * 权限认证
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        User user = userService.findByUserName(username);
        List<String> roles = roleService.findRoleByUserId(user.getId());
        List<String> ps = permissionServcie.queryPermissionsByShiro(user.getId());
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(new HashSet<String>(roles));
        authorizationInfo.setStringPermissions(new HashSet<String>(ps));
        return authorizationInfo;
    }
    /**
     * 身份认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String)authenticationToken.getPrincipal();
        User user = userService.findByUserName(username);
        if(user == null) {
            throw new UnknownAccountException();//没找到帐号
        }
       /* if(Boolean.TRUE.equals(user.getLocked())) {
            throw new LockedAccountException(); //帐号锁定
        }*/
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUserName(), //用户名
                user.getPassWord(), //密码
                ByteSource.Util.bytes(user.getUserName()+user.getSalt()),//用户名做盐处理
                getName()  //realm name
        );
        return authenticationInfo;
    }
}