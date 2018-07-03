package com.qppi.crud.auth;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Component;
/**
 * 表单认证过滤器，可以在这里记录登录成功后的日志记录等操作
 * 
 * @author dj
 * 
 */
@Component("authc")
public class FormAuthenticationCaptchaFilter extends FormAuthenticationFilter {
	public static final String DEFAULT_CAPTCHA_PARAM = "captcha";

	private String captchaParam = DEFAULT_CAPTCHA_PARAM;
	
	public String getCaptchaParam() {

		return captchaParam;

	}
	protected String getCaptcha(ServletRequest request) {

		return WebUtils.getCleanParam(request, getCaptchaParam());

	}
	
	protected AuthenticationToken createToken(ServletRequest request,
			ServletResponse response) {

		String username = getUsername(request);

		String password = getPassword(request) == null ? "" : getPassword(request);

		String captcha = getCaptcha(request);

		boolean rememberMe = isRememberMe(request);

		String host = getHost(request);

		return new UsernamePasswordCaptchaToken(username,

		password.toCharArray(), rememberMe, host, captcha);

	}
	
}
