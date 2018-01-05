package com.bee.sample.ch1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bee.sample.ch1.annotation.Function;
/**
 * 访问:http://127.0.0.1:8080/sayhello.html?name=springboot
 * @author xiandafu
 *
 */
@Controller
public class HelloworldController {


	/*
	xxxxxx leo.......所有使用Function的注解的方法，且在Controller注解标注的类里  begin
	xxxxxx leo.......所有Controller方法  begin
	args:[springboot]
			return :hello springboot
	xxxxxx leo.......所有Controller方法 end
	xxxxxx leo.......所有使用Function的注解的方法，且在Controller注解标注的类里 end
	*/
	@RequestMapping("/sayhello.html")
	@Function()
	public @ResponseBody String say(String name){
		System.out.println("xxxxxx leo.......sayhello.html");
		return "hello "+name;
	}
}
