package com.smhrd.echo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.smhrd.echo.model.CmtListInfo;
import com.smhrd.echo.model.CommentInfo;
import com.smhrd.echo.model.RecommendInfo;
import com.smhrd.echo.service.SocialService;


@RestController
public class SocialController {

	Gson gs = new Gson();

	@Autowired
	SocialService socialService;	
	
	// 댓글 조회
	@GetMapping("/api/comment/{board_seq}")
	public List<CmtListInfo> viewCmtList(@PathVariable("board_seq") int board_seq) {
    	return socialService.viewCmtList(board_seq);
	}
	
	// 댓글 등록
	@PostMapping("/api/comment/{board_seq}")
	public String addComment(@PathVariable("board_seq") int board_seq, @RequestBody CommentInfo comment) {
		System.out.println(board_seq);
		System.out.println(comment);
    	socialService.addComment(board_seq, comment);
    	return "success"; 
	}
	
	// 댓글 삭제
	@DeleteMapping("/api/comment")
	public void deleteComment(@RequestParam("seq") int cmt_seq,
			@RequestParam("board_seq") int board_seq) {
		System.out.println(cmt_seq);
		System.out.println(board_seq);
		socialService.deleteComment(cmt_seq, board_seq);
	}
	
	// 추천 조회
	@GetMapping("/api/reco")
	public RecommendInfo viewReco(@RequestParam("id") String user_id,
			@RequestParam("board_seq") int board_seq) {
		System.out.println("추천 조회 확인:"+user_id+board_seq);
    	return socialService.viewReco(user_id, board_seq);
	}
	
	// 추천 등록
	@PostMapping("/api/reco/{board_seq}")
	public void addReco(@PathVariable("board_seq") int board_seq, @RequestBody RecommendInfo reco) {
		System.out.println(board_seq);
		System.out.println(reco);
    	socialService.addReco(board_seq, reco);
	}
	
	// 추천 삭제
	@DeleteMapping("/api/reco")
	public void deleteReco(@RequestParam("id") String user_id,
			@RequestParam("board_seq") int board_seq) {
		System.out.println(user_id);
		System.out.println(board_seq);
		socialService.deleteReco(user_id, board_seq);
	}
	
	
}
