package com.smhrd.echo.model;

import java.sql.Date;

import lombok.Data;

@Data
public class CommentInfo {

    private int cmt_seq;

    private int board_seq;
    
    private String cmt_content;

    private Date cmt_dt;

    private String user_id;
	
}


