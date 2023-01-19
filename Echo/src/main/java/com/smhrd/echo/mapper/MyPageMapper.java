package com.smhrd.echo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.echo.model.MyPageInfo;

@Mapper
public interface MyPageMapper {
	
	public MyPageInfo getMyPage(String user_id);

}
