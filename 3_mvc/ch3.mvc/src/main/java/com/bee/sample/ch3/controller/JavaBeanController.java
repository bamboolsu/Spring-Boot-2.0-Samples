package com.bee.sample.ch3.controller;

import com.bee.sample.ch3.controller.form.OrderPostForm;
import com.bee.sample.ch3.entity.User;
import com.bee.sample.ch3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
/**
 * 通过form提交的各种映射举例
 * @author lijiazhi
 *
 */
@Controller
@RequestMapping("/javabean")
public class JavaBeanController {
	
	@Autowired UserService userService;


	//http://127.0.0.1:8080/javabean/update.json
	@GetMapping(path = "/update.json")
	@ResponseBody
	public String updateUser(User user) {
		System.out.println(user.getName());
		System.out.println(user.getId());
		return "success";
	}

	//http://127.0.0.1:8080/javabean/update2.json?id=12&name=jack
	@GetMapping(path = "/update2.json")
	@ResponseBody
	public String updateUser2(Integer id, String name) {
		System.out.println(id);
		System.out.println(name);
		return "success";
	}
	
	//http://127.0.0.1:8080/javabean/update3.json?id=12&name=jack
	//http://127.0.0.1:8080/javabean/update3.json?name=jack    ErrorCode:400  Message:Required Integer parameter 'id' is not present
	@GetMapping(path = "/update3.json")
	@ResponseBody
	public String updateUser3(@RequestParam(name="id",required=true) Integer id, String name) {
		System.out.println(id);
		System.out.println(name);
		return "success";
	}


	@PostMapping(path = "/saveOrder.json")
	@ResponseBody
	public String saveOrder( OrderPostForm form) {
		return "success";
	}
	
	@PostMapping(path = "/savejsonorder.json")
	@ResponseBody
	public String saveOrderByJson(@RequestBody User user) {
		return user.getName();
	}
	
}
