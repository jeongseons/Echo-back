package com.smhrd.echo.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Course {

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
	private ArrayList<Pair> latlngArray;
	
}
