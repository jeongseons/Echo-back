package com.smhrd.echo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.echo.mapper.UserMapper;
import com.smhrd.echo.model.MyPageInfo;
import com.smhrd.echo.model.UserInfo;

@Service
public class UserService {

	@Autowired
	UserMapper userMapper;
	
	public void joinUser(UserInfo userInfo) {
		userMapper.joinUser(userInfo);
	}

	public UserInfo loginUser(String user_id) {
		return userMapper.loginUser(user_id);
	}

	public void modifyUser(UserInfo userInfo) {
		userMapper.modifyUser(userInfo);
	}
	
	public void deleteUser(String user_id) {
		userMapper.deleteUser(user_id);
	}
	
	public MyPageInfo getMyPage(String user_id) {
		return userMapper.getMyPage(user_id);
	}

	
}
