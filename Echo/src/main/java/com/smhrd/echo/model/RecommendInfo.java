package com.smhrd.echo.model;

import java.sql.Date;

import lombok.Data;

@Data
public class RecommendInfo {
	
	private int reco_seq;
	private int board_seq;
	private String user_id;
	private Date reco_dt;

}
