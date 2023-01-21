package com.smhrd.echo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.echo.model.MyPageInfo;
import com.smhrd.echo.model.UserInfo;

@Mapper
public interface UserMapper {

	public void joinUser(UserInfo userInfo);

	public UserInfo loginUser(String user_id);
	
	public void modifyUser(UserInfo userInfo);
	
	public void deleteUser(String user_id);
	
	public MyPageInfo getMyPage(String user_id);
	
}
