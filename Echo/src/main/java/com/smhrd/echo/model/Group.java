package com.smhrd.echo.model;

import java.util.Date;

import lombok.Data;

@Data
public class Group {
	
	//그룹 번호
	private int group_seq;
	
	//그룹 생성자 아이디
	private String group_owner_id;
	
	//그룹 이미지
	private String group_profile_img;
	
	//그룹 이름
	private String group_name;
	
	//그룹 지역
	private String group_area;
	
	//인원 제한
	private int user_max;
	
	//연령 제한
	private String group_age;
	
	//산행 난이도
	private String group_level;
	
	//산행 일자
	private String group_dt;
	
	//일정 조정 여부
	private String group_yn;
	
	//성별 제한
	private String group_gender;
	
	//산행 구분
	private String group_type;

	//세부 일정
	private String group_detail;
	
	//가입한 그룹리스트를 위해 추가되는 정보
	//----------------------------
	//그룹원 권한
	private String group_auth;
	//그룹의 현재 인원수
	private int group_current;
	
}
