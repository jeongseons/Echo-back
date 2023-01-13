package com.smhrd.echo.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.echo.service.GroupService;
import com.smhrd.echo.model.Group;
import com.smhrd.echo.model.Joining_Group;
import com.smhrd.echo.model.UserInfo;

@RestController
public class GroupController {

	@Autowired
	GroupService groupService;
	
    @GetMapping("/api/grouplist")
    public List<Group> getGroupList(@RequestParam String user_id) {
        
    	List<Group> GroupList= groupService.getGroupList(user_id);
    	System.out.printf("group 확인용 : %s%n",GroupList);
    	
    	return GroupList;
    }
    
    @GetMapping("/api/personlist")
    public List<Joining_Group> getPersonList(@RequestParam int group_seq) {
        
    	List<Joining_Group> PersonList= groupService.getPersonList(group_seq);
    	System.out.printf("확인용 : %s%n",PersonList);
    	
    	return PersonList;
    }
    
    @GetMapping("/api/dropuser")
    public String dropUser(@RequestParam String user_nick) {
    	System.out.printf("닉네임 확인용 : %s%n",user_nick);
    	groupService.dropUser(user_nick);
    	
    	return "삭제완료";
    }
    
	@PostMapping("/api/addgroup")
	public int addGroup(@RequestBody Group group) {
		System.out.println(group);
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String dt = simpleDateFormat.format(group.getGroup_dt());
//		System.out.printf("형 변환 확인용 dt : %s%n", dt);	
		System.out.printf("형 변환 확인용 getgroup.dt : %s%n", group.getGroup_dt());	
//		group.setGroup_dt(dt);
//		System.out.printf("형 변환 확인용 group : %s%n", group);		
	
		//		groupService.addGroup(group);
//		System.out.println(user.toString());
    	return 1;
    	}
	

	
}
