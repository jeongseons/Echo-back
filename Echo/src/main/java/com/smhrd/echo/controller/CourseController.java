package com.smhrd.echo.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.echo.model.CourseInfo;
import com.smhrd.echo.model.CourseList;
import com.smhrd.echo.model.MapInfo;
import com.smhrd.echo.model.ModifiedCourse;
import com.smhrd.echo.model.Course;
import com.smhrd.echo.model.Pair;
import com.smhrd.echo.service.CourseService;

@RestController
public class CourseController {
	
	Pair pair = new Pair(0, 0);

	@Autowired
	CourseService courseService;
	
	// 경로 추가
	@PostMapping("/api/course")
	public void addCourse(@RequestBody Course course) {
		CourseInfo courseInfo = new CourseInfo(course.getCourse_seq(), course.getUser_id(), course.getCourse_title(),
				course.getCourse_time(),course.getCourse_alt(),course.getCourse_distance(),
				course.getCourse_start_dt(), course.getCourse_end_dt(), course.getCourse_open(), course.getCourse_img());
		
		courseService.addCourse(courseInfo);
		
		int course_seq = courseInfo.getCourse_seq();
		System.out.println("course_seq:"+course_seq);
		
	    Map<String, Object> paramMap = new HashMap<String, Object>();
	    
	    paramMap.put("course_seq", course_seq);
	    paramMap.put("latlngArray", course.getLatlngArray());

    	courseService.addMap(paramMap); 
    	
	}
	
	// 경로 목록 조회
	@GetMapping("/api/course/user/{user_id}")
	public List<CourseList> getCourse(@PathVariable("user_id") String user_id) {
		System.out.println(user_id);
		System.out.println(courseService.getCourse(user_id));
		return courseService.getCourse(user_id);
	}
	
	// 단일 경로 조회
	@GetMapping("/api/course/{course_seq}")
	public List<CourseList> getOneCourse(@PathVariable("course_seq") int course_seq) {
		return courseService.getOneCourse(course_seq);
	}
	
	// 지도 정보 조회
	@GetMapping("/api/course/{course_seq}/map")
	public List<MapInfo> getMap(@PathVariable("course_seq") int course_seq){
		System.out.println(course_seq);
		System.out.println(courseService.getMap(course_seq));
		return courseService.getMap(course_seq);
	}
	
	// 경로 정보 수정
	@PutMapping("/api/course")
	public void modifyCourse(@RequestBody ModifiedCourse modifiedCourse) {
		courseService.modifyCourse(modifiedCourse);
	}
	
	// 경로 삭제
	@DeleteMapping("/api/course/{course_seq}")
	public void deleteCourse(@PathVariable("course_seq") int course_seq) {
		courseService.deleteMap(course_seq);
		courseService.deleteCourse(course_seq);
	}
	
	// 경로 삭제 - 다수
	@DeleteMapping("/api/course")
	public void deleteSelectedBoard(@RequestBody List<Integer> courseSeqList)  {
		System.out.println(courseSeqList);
		courseService.deleteSelectedMap(courseSeqList);
		courseService.deleteSelectedCourse(courseSeqList);
	}
	
}

