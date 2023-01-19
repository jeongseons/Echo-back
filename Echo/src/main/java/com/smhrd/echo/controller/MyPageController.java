package com.smhrd.echo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.echo.model.CmtListInfo;
import com.smhrd.echo.model.MyPageInfo;
import com.smhrd.echo.service.MyPageService;

@RestController
public class MyPageController {

	@Autowired
	MyPageService myPageService;
	
	@GetMapping("/api/user/{user_id}")
	public MyPageInfo getMyPage(@PathVariable("user_id") String user_id) {
    	return myPageService.getMyPage(user_id);
	}
	
}
