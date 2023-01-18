package com.smhrd.echo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.echo.model.BoardInfo;
import com.smhrd.echo.model.BoardListInfo;

@Mapper
public interface BoardMapper {

	public List<BoardListInfo> viewBoardList();

	public void addBoard(BoardInfo board);

	public void deleteBoard(int board_seq);
	
	public void modifyBoard(BoardInfo board);
	
}
