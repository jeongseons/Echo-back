package com.smhrd.echo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.echo.mapper.UserMapper;
import com.smhrd.echo.model.UserInfo;

@Service
public class UserService {

	@Autowired
	UserMapper userMapper;
	
	public void joinUser(UserInfo userInfo) {
		userMapper.joinUser(userInfo);
	}

	public List<UserInfo> loginUser(String user_id) {
		return userMapper.loginUser(user_id);
	}



	
}
