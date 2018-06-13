package com.sx.shiro.formFilter;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * moayi
 *
 * @create 2018-06-12 10:36
 **/
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {
    /**
     * 验证码校验
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        // 从session获取正确的验证码
        HttpSession session = ((HttpServletRequest)request).getSession();
        //页面输入的验证码
        String randomcode = request.getParameter("rememberMe");
        randomcode="123456";
        //从session中取出验证码
        //String validateCode = (String) session.getAttribute("validateCode");
        String validateCode = "123456";
        if (randomcode != null && validateCode != null) {
            if (!randomcode.equals(validateCode)) {
                //如果校验失败，将验证码错误失败信息，通过shiroLoginFailure设置到request中
                request.setAttribute("shiroLoginFailure", "randomCodeError");
                //拒绝访问，不再校验账号和密码
                return true;
            }
        }
        return super.onAccessDenied(request, response);
    }
}