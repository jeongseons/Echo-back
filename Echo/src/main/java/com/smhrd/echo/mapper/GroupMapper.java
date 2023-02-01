package com.smhrd.echo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.echo.model.Calendar;
import com.smhrd.echo.model.CalendarInfo;
import com.smhrd.echo.model.Group;
import com.smhrd.echo.model.Joining_Group;

@Mapper
public interface GroupMapper {
	// 가입한 그룹 정보
	public List<Group> getGroupList(String id);
	
	// 그룹에 가입한 회원 정보
	public List<Joining_Group> getPersonList(int seq);
	
	// 그룹 회원 강퇴
	public void dropUser(String nick);
	
	// 그룹 생성
	public void addGroup(Group group);
	
	// 그룹 조건검색
	public List<Group> joinGroupCon(Group group);

	// 그룹 최신순 리스트
	public List<Group> joinGroupList();
	
	// 그룹 그룹장으로 검색
	public List<Group> joinGroupNick(String nick);
	
	// 그룹 정보조회
	public Group joinGroupPro(int num, String id);
	
	// 그룹 가입신청
	public void groupSignUp(int num, String id);
	
	// 그룹장 생성
	public void addGroupOwner(Group group);	
	
	// 일정 생성
	public void addCal(Calendar cal);
	
	// 일정 불러오기
	public List<CalendarInfo> getCalList(int seq);
	
	// 가입승인
	public void groupAgree(int num, String nick);
	
	// 가입거부, 탈퇴
	public void groupDegree(int num, String nick);
	
	// 가입 대기중인 인원 리스트
	public List<Joining_Group> getSignUpList(int num);
	
	// 일정 삭제
	public void deleteCal(int cal_seq);
	
	// 일정 수정
	public void modifyCal(CalendarInfo cal);
	
	// 그룹 삭제
	public void deleteGroup(int group_seq);
	
	// 그룹 정보 수정 
	public void modifyGroup(Group group);
	
	// 그룹 탈퇴
	public void quitGroup(int group_seq, String user_id); 
	
}
