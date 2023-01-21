package com.smhrd.echo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smhrd.echo.mapper.SocialMapper;
import com.smhrd.echo.model.CmtListInfo;
import com.smhrd.echo.model.CommentInfo;
import com.smhrd.echo.model.RecommendInfo;

@Service
public class SocialService {
	
	@Autowired
	SocialMapper socialMapper;
	
	// 댓글 조회
	public List<CmtListInfo> viewCmtList(int board_seq) {
    	return socialMapper.viewCmtList(board_seq);
	}
	
	// 댓글 등록
	public void addComment(int board_seq, CommentInfo comment) {
    	socialMapper.addComment(board_seq, comment);
	}
	
	// 댓글 삭제
	public void deleteComment(int cmt_seq, int board_seq) {
		System.out.println(cmt_seq);
		System.out.println(board_seq);
		socialMapper.deleteComment(cmt_seq, board_seq);
	}
	
	// 추천 조회
	public RecommendInfo viewReco(String user_id, int board_seq) {
		return socialMapper.viewReco(user_id, board_seq);
	}
	
	// 추천 등록
	public void addReco(int board_seq, RecommendInfo reco) {
		socialMapper.addReco(board_seq, reco);
	}
	
	// 추천 삭제
	public void deleteReco(String user_id, int board_seq) {
		socialMapper.deleteReco(user_id, board_seq);
	}
	
}
