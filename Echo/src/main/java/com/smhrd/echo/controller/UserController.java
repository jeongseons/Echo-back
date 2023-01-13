package com.smhrd.echo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/api/join")
    public String join() {
        
    	String res = "";
    	
    	return res;
    }
}
