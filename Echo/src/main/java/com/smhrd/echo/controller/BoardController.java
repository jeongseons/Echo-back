package com.smhrd.echo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.smhrd.echo.model.BoardInfo;
import com.smhrd.echo.model.BoardListInfo;
import com.smhrd.echo.model.UserInfo;
import com.smhrd.echo.service.BoardService;
import com.smhrd.echo.service.UserService;

@RestController
public class BoardController {

	Gson gs = new Gson();

	@Autowired
	BoardService boardService;	
	
	@GetMapping("/api/board")
	public List<BoardListInfo> viewBoardList() {
    	return boardService.viewBoardList();
	}
	
	@PostMapping("/api/board")
	public String addBoard(@RequestBody BoardInfo board) {
//		String json = gs.toJson(board);
//    	BoardInfo boards = gs.fromJson(json, BoardInfo.class);
		System.out.println(board);
    	boardService.addBoard(board);
		
    	return "success"; 
	}
	
	@DeleteMapping("/api/board/{board_seq}")
	public void deleteBoard(@PathVariable("board_seq") int board_seq) {
		System.out.println(board_seq);
		boardService.deleteBoard(board_seq);
	}
	
	@PutMapping("/api/board")
	public void modifyBoard(@RequestBody BoardInfo board) {
		System.out.println(board);
		boardService.modifyBoard(board);
	}
	
}
