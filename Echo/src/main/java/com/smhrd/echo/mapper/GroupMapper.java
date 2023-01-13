package com.smhrd.echo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.echo.model.Group;
import com.smhrd.echo.model.Joining_Group;

@Mapper
public interface GroupMapper {
	// 가입한 그룹 정보
	public List<Group> getGroupList(String id);
	
	// 그룹에 가입한 회원 정보
	public List<Joining_Group> getPersonList(int seq);;
	
	// 그룹 회원 강퇴
	public void dropUser(String nick);
	
	// 그룹 생성
	public void addGroup(Group group);
}
