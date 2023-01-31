package com.smhrd.echo.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.echo.service.GroupService;
import com.smhrd.echo.model.Calendar;
import com.smhrd.echo.model.CalendarInfo;
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
		List<Group> GroupList;
		
		if(group.getGroup_age().equals("무관")&&group.getGroup_level().equals("무관")&&group.getGroup_level().equals("무관")&&group.getGroup_area().equals("전국")&&group.getGroup_type().equals("등산/등반")) {
			GroupList = groupService.joinGroupList();	
		}
		else {
			GroupList = groupService.joinGroupCon(group);
		}
		
		System.out.println("sql 확인" + GroupList);
		
		return GroupList;
	}
	
	@GetMapping("/api/joingrouplist")
	public List<Group> JoinGroupList(){ // 그룹 전체 불러오기 (생성순)
		
		List<Group> GroupList = groupService.joinGroupList();		
		
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
	
	@PostMapping("/api/groupsignup/{num}")
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
    public List<CalendarInfo> getCalList(@RequestParam int group_seq) { //그룹의 일정 불러오기
        
    	List<CalendarInfo> CalList= groupService.getCalList(group_seq);
    	System.out.printf("확인용 : %s%n",CalList);
    	
    	return CalList;
    }

	// 일정 삭제
	@DeleteMapping("/api/cal/{cal_seq}")
	public void deleteCal(@PathVariable("cal_seq") int cal_seq) {
		System.out.println(cal_seq);
		groupService.deleteCal(cal_seq);
	}
	
	// 일정 수정
	@PutMapping("/api/cal")
	public void modifyCal(@RequestBody CalendarInfo cal) {
		System.out.println(cal);
		groupService.modifyCal(cal);
	}
	
	@GetMapping("/api/getsignuplist/{num}")
	public List<Joining_Group> getSignUpList(@PathVariable int num) { // 그룹의 가입대기 인원 불러오기

		List<Joining_Group> PersonList = groupService.getSignUpList(num);
		System.out.printf("확인용 : %s%n", PersonList);

		return PersonList;
	}
	
	@PostMapping("/api/groupagree/{num}")
	public String groupAgree(@PathVariable int num, @RequestParam String user_nick) {// 그룹가입 허가
		System.out.printf("닉네임 확인용 : %s%n", user_nick);
		groupService.groupAgree(num, user_nick);

		return "가입완료";
	}
	
	@PostMapping("/api/groupdegree/{num}")
	public String groupDegree(@PathVariable int num, @RequestParam String user_nick) {// 가입거절, 탈퇴
		System.out.printf("닉네임 확인용 : %s%n", user_nick);
		groupService.groupDegree(num, user_nick);

		return "거절 및 탈퇴완료";
	}

	
	@DeleteMapping("/api/group/{group_seq}")
	public void deleteGroup(@PathVariable int group_seq) { // 그룹 삭제
		groupService.deleteGroup(group_seq);
	}
	
	@PutMapping("/api/group")
	public void modifyGroup(@RequestBody Group group) { // 그룹 정보 수정
		groupService.modifyGroup(group);
	}
}

