package com.smhrd.echo.model;

import lombok.Data;

@Data
public class CourseInfo {

	public CourseInfo(int course_seq2, String user_id2, String course_title2, String course_time2, String course_alt2,
			String course_distance2, String course_start_dt2, String course_end_dt2, String course_open2,
			String course_img2) {
		// TODO Auto-generated constructor stub
	}
	private int course_seq;
	private String user_id;
	private String course_title;
	private String course_time;
	private String course_alt;
	private String course_distance;
	private String course_start_dt;
	private String course_end_dt;
	private String course_open;
	private String course_img;

}
