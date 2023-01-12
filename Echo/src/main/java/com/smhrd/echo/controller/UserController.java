package com.smhrd.echo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.echo.model.UserInfo;
import com.smhrd.echo.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;	
	
	@PostMapping("/api/join")
	public String login(@RequestBody UserInfo user) {

		return "";
	}
	
}


