package com.smhrd.echo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.echo.model.UserInfo;

@Mapper
public interface UserMapper {

	public void joinUser(UserInfo userInfo);

	public List<UserInfo> loginUser(String user_id);
	
}
