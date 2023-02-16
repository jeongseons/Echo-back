package com.smhrd.echo.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.echo.model.ChatMessage;

import org.springframework.messaging.simp.SimpMessageHeaderAccessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class ChatController {

    @MessageMapping("chat")
    @SendTo("/topic/message")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
    	System.out.println("확인1:");
    	//System.out.println(chatMessage.getContent());
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/2")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor){
    	System.out.println("확인2:");
    	//headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
}
