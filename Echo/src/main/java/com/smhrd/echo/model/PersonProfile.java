package com.smhrd.echo.model;

import java.util.List;

import lombok.Data;

@Data
public class PersonProfile {

	private MyPageInfo personInfo;
	private List<BoardListInfo> boardList;
	private List<CourseList> courseList;
	
}
