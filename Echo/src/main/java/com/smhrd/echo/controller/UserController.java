package com.smhrd.echo.controller;

import java.util.List;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.smhrd.echo.model.UserInfo;
import com.smhrd.echo.service.UserService;

@RestController
public class UserController {
	
	Gson gs = new Gson();

	@Autowired
	UserService userService;	
	
	@PostMapping("/api/join")
	public String userJoin(@RequestBody UserInfo user) {
		String json = gs.toJson(user);
    	UserInfo users = gs.fromJson(json, UserInfo.class);

    	userService.joinUser(users);
		
    	return "success"; 
	}
	
	@PostMapping("/api/login")
	public List<UserInfo> userLogin(@RequestBody String user_id) {
		user_id = user_id.substring(1, user_id.length()-1);
		System.out.println(user_id);
		List<UserInfo> user = userService.loginUser(user_id);
		System.out.println(user.toString());
    	return user;
	}
	
}


