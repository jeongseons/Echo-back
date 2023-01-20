package com.smhrd.echo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.echo.model.CmtListInfo;
import com.smhrd.echo.model.CommentInfo;
import com.smhrd.echo.model.RecommendInfo;

@Mapper
public interface SocialMapper {

	public List<CmtListInfo> viewCmtList(int board_seq);
	
	public void addComment(int board_seq, CommentInfo comment);
	
	public void deleteComment(int cmt_seq, int board_seq);
	
	public RecommendInfo viewReco(String user_id, int board_seq);
	
	public void addReco(int board_seq, RecommendInfo reco);
	
	public void deleteReco(String user_id, int board_seq);
	
}
