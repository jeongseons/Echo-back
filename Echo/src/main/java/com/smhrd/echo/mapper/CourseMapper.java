package com.smhrd.echo.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.echo.model.CourseInfo;
import com.smhrd.echo.model.CourseList;
import com.smhrd.echo.model.MapInfo;
import com.smhrd.echo.model.ModifiedCourse;
import com.smhrd.echo.model.Pair;


@Mapper
public interface CourseMapper {

	public void addCourse(CourseInfo courseInfo);
	
	public void addMap(Map<String, Object> paramMap);
	
	public List<CourseList> getCourse(String user_id);
	
	public List<CourseList> getOneCourse(int course_seq);
	
	public List<MapInfo> getMap(int course_seq);
	
	public void modifyCourse(ModifiedCourse modifiedCourse);
	
	public void deleteCourse(int course_seq);
	
	public void deleteMap(int course_seq);
	
	public void deleteSelectedCourse(List<Integer> courseSeqList);
	
	public void deleteSelectedMap(List<Integer> courseSeqList);

}