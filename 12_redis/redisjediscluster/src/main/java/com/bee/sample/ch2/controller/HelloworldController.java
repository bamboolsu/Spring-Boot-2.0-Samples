package com.bee.sample.ch2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloworldController {
	//http://127.0.0.1:8080/sayhello.html?name=springboot
	@RequestMapping("/sayhello.html")
	public @ResponseBody String say(){
		return "hello ";
	}

	//http://127.0.0.1:8080/say.html?name=springboot
	@RequestMapping("/say.html")
	public @ResponseBody String say(String name){
		return "hello world "+name;
	}
}
