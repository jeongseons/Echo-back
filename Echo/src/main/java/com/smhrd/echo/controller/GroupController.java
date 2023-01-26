package com.smhrd.echo.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.echo.service.GroupService;
import com.smhrd.echo.model.Calendar;
import com.smhrd.echo.model.Group;
import com.smhrd.echo.model.Joining_Group;
import com.smhrd.echo.model.UserInfo;

@RestController
public class GroupController {

	@Autowired
	GroupService groupService;

	@GetMapping("/api/grouplist")
	public List<Group> getGroupList(@RequestParam String user_id) {// 그룹 리스트 불러오기

		List<Group> GroupList = groupService.getGroupList(user_id);
		System.out.printf("group 확인용 : %s%n", GroupList);

		return GroupList;
	}

	@GetMapping("/api/personlist")
	public List<Joining_Group> getPersonList(@RequestParam int group_seq) { // 그룹의 소속 그룹원 불러오기

		List<Joining_Group> PersonList = groupService.getPersonList(group_seq);
		System.out.printf("확인용 : %s%n", PersonList);

		return PersonList;
	}

	@GetMapping("/api/dropuser")
	public String dropUser(@RequestParam String user_nick) {// 그룹원 강퇴
		System.out.printf("닉네임 확인용 : %s%n", user_nick);
		groupService.dropUser(user_nick);

		return "삭제완료";
	}

	@PostMapping("/api/addgroup")
	public int addGroup(@RequestBody Group group) {// 그룹 생성
		System.out.println(group);

		groupService.addGroup(group);
		System.out.println(group.getGroup_seq());
		System.out.println("리그룹 : " + group);

		// 그룹장이 그룹 생성과 동시에 그룹원 테이블에 정보 추가.
		groupService.addGroupOwner(group);

		return 1;
	}

	@PostMapping("/api/joingroupcon")
	public List<Group> joinGroupCon(@RequestBody Group group) {// 그룹 검색 (조건) 
		System.out.println("조건" + group);

		List<Group> GroupList = groupService.joinGroupCon(group);

		return GroupList;
	}

	@GetMapping("/api/joingroupnick")
	public List<Group> joinGroupNick(@RequestParam String user_nick) {// 그룹 검색 (닉네임)
		System.out.printf("닉네임 확인용 : %s%n", user_nick);
		List<Group> GroupList = groupService.joinGroupNick(user_nick);
		System.out.println("닉네임 :"+GroupList);
		
		
		return GroupList; 
	}
	
	
	@GetMapping("/api/joingrouppro/{num}/{id}")
	public Group joinGroupPro(@PathVariable("num") int num, @PathVariable("id") String id) {// 그룹프로필 조회
		System.out.println("확인용"+num);
		System.out.println("확인용"+id);
		
		Group group = groupService.joinGroupPro(num, id);
		System.out.println("확인용"+group);

		return group;
	}
	
	@PostMapping("/api/groupsingup/{num}")
	public int groupSignUp(@PathVariable("num") int num,@RequestParam String id) {// 그룹가입 신청
		System.out.println(id);
		System.out.println(num);
		
		groupService.groupSignUp(num, id);

		return 1;
	}


	@PostMapping("/api/addcal")
	public int addCal(@RequestBody Calendar calendar) {// 일정 생성
		System.out.println(calendar);

		groupService.addCal(calendar);

		return 1;
	}

	@GetMapping("/api/callist")
	public List<Calendar> getCalList(@RequestParam int group_seq) { // 그룹의 일정 불러오기

		List<Calendar> CalList = groupService.getCalList(group_seq);
		System.out.printf("확인용 : %s%n", CalList);

		return CalList;
	}

}
