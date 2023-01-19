package com.smhrd.echo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.echo.mapper.MyPageMapper;
import com.smhrd.echo.model.MyPageInfo;

@Service
public class MyPageService {

	@Autowired
	MyPageMapper myPageMapper;
	
	public MyPageInfo getMyPage(String user_id) {
		return myPageMapper.getMyPage(user_id);
	}
	
}
