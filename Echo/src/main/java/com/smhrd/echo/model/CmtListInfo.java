package com.smhrd.echo.model;

import java.sql.Date;

import lombok.Data;

@Data
public class CmtListInfo {
	//댓글 조회에 필요한 정보(닉네임) 추가

    	private int cmt_seq;

	    private int board_seq;
	    
	    private String cmt_content;

	    private String cmt_dt;

	    private String user_id;
	    
	    private String user_nick;
	    	    
}
