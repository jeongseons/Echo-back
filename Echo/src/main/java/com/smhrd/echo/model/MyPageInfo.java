package com.smhrd.echo.model;

import lombok.Data;

@Data
public class MyPageInfo {

    private String user_id;

    private String user_nick;
    
    private String user_birthdate;

    private String user_profile_img;

    private String user_gender;
    
    private int user_board_cnt;
    
    private int user_course_cnt;
    
    private String user_type;
    
}
