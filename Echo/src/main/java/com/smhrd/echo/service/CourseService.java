package com.smhrd.echo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.echo.mapper.CourseMapper;
import com.smhrd.echo.model.CourseInfo;
import com.smhrd.echo.model.CourseList;
import com.smhrd.echo.model.MapInfo;
import com.smhrd.echo.model.ModifiedCourse;
import com.smhrd.echo.model.Pair;

@Service
public class CourseService {
	
	@Autowired
	CourseMapper courseMapper;
	
	public void addCourse(CourseInfo courseInfo) {
		courseMapper.addCourse(courseInfo);
	}
	
	public void addMap(Map<String, Object> paramMap) {
		courseMapper.addMap(paramMap);
	}

	public List<CourseList> getCourse(String user_id){
		return courseMapper.getCourse(user_id);
	}
	
	public List<CourseList> getOneCourse(int course_seq){
		return courseMapper.getOneCourse(course_seq);
	}
	
	public List<MapInfo> getMap(int course_seq){
		return courseMapper.getMap(course_seq);
	}
	
	public void modifyCourse(ModifiedCourse modifiedCourse) {
		courseMapper.modifyCourse(modifiedCourse);
	}
	
	public void deleteCourse(int course_seq) {
		courseMapper.deleteCourse(course_seq);
	}
	
	public void deleteMap(int course_seq) {
		courseMapper.deleteMap(course_seq);
	}
	
	public void deleteSelectedCourse(List<Integer> courseSeqList) {
		courseMapper.deleteSelectedCourse(courseSeqList);
	}
	
	public void deleteSelectedMap(List<Integer> courseSeqList) {
		courseMapper.deleteSelectedMap(courseSeqList);
	}
	
	
}
