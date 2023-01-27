package com.smhrd.echo.model;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardListInfo {
	//게시글 조회에 필요한 정보(닉네임, 추천수) 추가
	
    private int board_seq;

    private String board_title;
    
    private String board_content;

    private String board_file;

    private String board_dt;

    private String user_id;
    
    private String mnt_name;

    private String user_nick;
    
    // 게시글 추천 수
    private int board_reco_cnt;
    
}
