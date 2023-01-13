package com.smhrd.echo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.echo.mapper.GroupMapper;
import com.smhrd.echo.model.Group;

@Service
public class GroupService {

	@Autowired
	GroupMapper groupmapper;
	
	public List<Group> getGroupList(String user_id){
		return groupmapper.getGroupList(user_id);
	}
	
	
}
