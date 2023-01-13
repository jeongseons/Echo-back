package com.smhrd.echo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.echo.mapper.GroupMapper;
import com.smhrd.echo.model.Group;
import com.smhrd.echo.model.Joining_Group;

@Service
public class GroupService {

	@Autowired
	GroupMapper groupMapper;
	
	public List<Group> getGroupList(String user_id){
		return groupMapper.getGroupList(user_id);
	}
	
	public List<Joining_Group> getPersonList(int group_seq){
		return groupMapper.getPersonList(group_seq);
	}
	
	public void addGroup(Group group) {
		groupMapper.addGroup(group);	
	}
	
	public void dropUser(String nick) {
		groupMapper.dropUser(nick);
	}
	
	
}
