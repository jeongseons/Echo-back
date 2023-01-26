package com.smhrd.echo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.smhrd.echo.model.BoardInfo;
import com.smhrd.echo.model.BoardListInfo;
import com.smhrd.echo.service.BoardService;

@RestController
public class BoardController {

	Gson gs = new Gson();

	@Autowired
	BoardService boardService;	
	
	// 게시글 정보 조회
	@GetMapping("/api/board")
	public List<BoardListInfo> viewBoardList(@RequestParam(value="id", required=false) String user_id) {
    	return boardService.viewBoardList(user_id);
	}
	
	// 게시글 작성
	@PostMapping("/api/board")
	public String addBoard(@RequestBody BoardInfo board) {
		System.out.println(board);
    	boardService.addBoard(board);
		
    	return "success"; 
	}
	
	// 게시글 삭제
	@DeleteMapping("/api/board/{board_seq}")
	public void deleteBoard(@PathVariable("board_seq") int board_seq) {
		System.out.println(board_seq);
		boardService.deleteBoard(board_seq);
	}
	
	// 게시글 수정
	@PutMapping("/api/board")
	public void modifyBoard(@RequestBody BoardInfo board) {
		System.out.println(board);
		boardService.modifyBoard(board);
	}
	
}
