package com.smhrd.echo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.echo.service.GroupService;
import com.smhrd.echo.model.Group;

@RestController
public class GroupController {

	@Autowired
	GroupService groupService;
	
    @GetMapping("/api/grouplist")
    public List<Group> getGroupList(@RequestParam String user_id) {
        
    	List<Group> GroupList= groupService.getGroupList(user_id);
    	System.out.printf("확인용 : %s%n",GroupList);
    	
    	return GroupList;
    }
}
