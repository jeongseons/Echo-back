package com.smhrd.echo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.echo.mapper.GroupMapper;
import com.smhrd.echo.model.Calendar;
import com.smhrd.echo.model.CalendarInfo;
import com.smhrd.echo.model.Group;
import com.smhrd.echo.model.Joining_Group;

@Service
public class GroupService {

	@Autowired
	GroupMapper groupMapper;
	
	public List<Group> getGroupList(String user_id){ // 가입한 그룹 불러오기
		return groupMapper.getGroupList(user_id);
	}
	
	public List<Joining_Group> getPersonList(int group_seq){ // 그룹원 불러오기
		return groupMapper.getPersonList(group_seq);
	}
	
	public void addGroup(Group group) { // 모임 생성
		groupMapper.addGroup(group);	
	}
	
	public List<Group> joinGroupCon(Group group){ // 조건으로 그룹 검색
		return groupMapper.joinGroupCon(group);
	}
	
	public List<Group> joinGroupNick(String nick){ // 그룹장으로 그룹 검색
		return groupMapper.joinGroupNick(nick);
	}
	
	public Group joinGroupPro(int num, String id){ // 그룹 정보 조회
		return groupMapper.joinGroupPro(num, id);
	}
	
	public void groupSignUp(int num, String id) { // 가입 신청
		groupMapper.groupSignUp(num, id);	
	}

	
	public void addGroupOwner(Group group) { // 그룹장 추가
		groupMapper.addGroupOwner(group);	
	}
	
	public void dropUser(String nick) { // 그룹원 강퇴
		groupMapper.dropUser(nick);
	}
	
	public void addCal(Calendar cal) { // 일정 추가
		groupMapper.addCal(cal);
	}
	
	public List<CalendarInfo> getCalList(int seq){ // 일정 불러오기
		return groupMapper.getCalList(seq);
	}
	
	public void groupAgree(int num, String nick) {// 가입 승인
		groupMapper.groupAgree(num, nick);
}

	public void deleteCal(int cal_seq) { // 일정 삭제
		groupMapper.deleteCal(cal_seq);
	}

	public void groupDegree(int num, String nick) {// 가입 거부
		groupMapper.groupAgree(num, nick);
	}
	
	public List<Joining_Group> getSignUpList(int num){ // 가입 대기중 인원 불러오기
		return groupMapper.getSignUpList(num);
	}
	
	public void modifyCal(CalendarInfo cal) { // 일정 수정
		groupMapper.modifyCal(cal);
	}
	
	
}
