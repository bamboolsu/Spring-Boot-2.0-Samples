package com.bee.sample.ch3.conf;

import java.text.ParseException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.bee.sample.ch3.entity.User;

@Configuration
public class MvcConfigurer implements WebMvcConfigurer {

	// 拦截器
	public void addInterceptors(InterceptorRegistry registry) {
		//增加一个拦截器, 检查会话, URL以user开头的都使用此拦截器
		registry.addInterceptor(new SessionHandlerInterceptor()).addPathPatterns("/user/**");
	}
	public void addCorsMappings(CorsRegistry registry) {
		// 运行所有跨域访问,
		//registry.addMapping("/**");

		//仅仅允许来自domain2.com 的跨域访问, 并且限定访问路径为/api,  方法是 POST 或者get
		//registry.addMapping("/api/**").allowedOrigins("http://domain2.com").allowedMethods("POST", "GET");
	}

	//格式化
	public void addFormatters(FormatterRegistry registry) {
		 registry.addFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
		
	}


	//URI到视图的映射
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/index.html").setViewName("/index.btl");
		registry.addRedirectViewController("/**/*.do", "/index.html");
	}
	
	/**
	 * 
	 * 检查用户是否已经登录，如果未登录，重定向到登录页面
	 *
	 */
	class SessionHandlerInterceptor implements HandlerInterceptor{
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {
			User user = (User) request.getSession().getAttribute("user"); 
			if(user==null){
				// 如果灭有登录, 重定向到login.html
				response.sendRedirect("/login.html");
				return false;
			}
			return true;
		}
	}
	
	

}
