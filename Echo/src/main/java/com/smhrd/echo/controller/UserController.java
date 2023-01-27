package com.smhrd.echo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.echo.model.MyPageInfo;
import com.smhrd.echo.model.UserInfo;
import com.smhrd.echo.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;	
	
	@PostMapping("/api/user")
	public String joinUser(@RequestBody UserInfo user) {
    	userService.joinUser(user);
		
    	return "success"; 
	}
	
	@GetMapping("/api/login/{user_id}")
	public UserInfo loginUser(@PathVariable("user_id") String user_id) {
		UserInfo user = userService.loginUser(user_id);
		System.out.println(user.toString());
    	return user;
    }
		
	@PutMapping("/api/user")
	public void modifyUser (@RequestBody UserInfo user) {
		userService.modifyUser(user);
	}
	
	@DeleteMapping("/api/user/{user_id}")
	public void deleteUser (@PathVariable("user_id") String user_id) {
		userService.deleteUser(user_id);
	}
	
	@GetMapping("/api/user/{user_id}")
	public MyPageInfo getMyPage(@PathVariable("user_id") String user_id) {
    	return userService.getMyPage(user_id);
	}
	
}

