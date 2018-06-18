package com.sx.shiro.filter;

import com.sx.service.UserService;
import com.sx.shiro.constants.Constants;
import lombok.AllArgsConstructor;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
@Component
public class SysUserFilter extends PathMatchingFilter {
    @Autowired
    private UserService userService;
    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

        String username = (String) SecurityUtils.getSubject().getPrincipal();
        request.setAttribute(Constants.CURRENT_USER, userService.findByUserName(username));
        return true;
    }
}
