package com.smhrd.echo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.echo.model.UserInfo;

@Mapper
public interface UserMapper {

	public void joinUser(UserInfo userInfo);
	
}
