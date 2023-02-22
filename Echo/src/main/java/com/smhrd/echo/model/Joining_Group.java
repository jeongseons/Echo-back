package com.smhrd.echo.model;

import lombok.Data;

@Data
public class Joining_Group {
	
	//가입 순번
	private int join_seq;
	
	//그룹 번호
	private int group_seq;

	//가입 아이디
	private String user_id;
	
	//가입 날짜
	private String join_dt;
	
	//그룹 권한
	private String group_auth;
	
	//가입한 회원 정보용 필드 정보
	//프로필 이미지
	private String user_profile_img;
	
	//유저 닉네임
	private String user_nick;
	
	private String user_type;
	
}
