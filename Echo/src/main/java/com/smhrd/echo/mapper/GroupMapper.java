package com.smhrd.echo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.echo.model.Group;

@Mapper
public interface GroupMapper {
	// 가입한 그룹 정보
	public List<Group> getGroupList(String id);
}
