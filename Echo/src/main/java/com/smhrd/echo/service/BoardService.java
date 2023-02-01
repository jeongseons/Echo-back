package com.smhrd.echo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smhrd.echo.mapper.BoardMapper;
import com.smhrd.echo.model.BoardInfo;
import com.smhrd.echo.model.BoardListInfo;

@Service
public class BoardService {

	@Autowired
	BoardMapper boardMapper;
	
	public List<BoardListInfo> viewBoardList(String user_id) {
		return boardMapper.viewBoardList(user_id);
	}

	public void addBoard(BoardInfo board) {
		boardMapper.addBoard(board);
	}
	
	public void deleteBoard(int board_seq) {
		boardMapper.deleteBoard(board_seq);
	}
	
	public void modifyBoard(BoardInfo board) {
		boardMapper.modifyBoard(board);
	}

	public void deleteSelectedBoard(List<Integer> boardSeqList) {
		boardMapper.deleteSelectedBoard(boardSeqList);
	}
}
