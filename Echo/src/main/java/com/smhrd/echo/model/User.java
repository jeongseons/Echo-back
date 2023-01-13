package com.smhrd.echo.model;

import lombok.Data;

@Data
public class User {
	//유저 닉네임
	private String user_Nick;
	
	//유저 생년월일
	private String user_Date;
	
	//유저 아이디
	private String user_Id;
	
	//유저 프로필 사진경로
	private String user_Pic;
	
	//유저 성별
	private String user_Gen;
}
