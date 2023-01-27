package com.smhrd.echo.model;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardInfo {

	    private int board_seq;

	    private String board_title;
	    
	    private String board_content;

	    private String board_file;

	    private String board_dt;

	    private String user_id;

	    private String mnt_name;
	    
}
