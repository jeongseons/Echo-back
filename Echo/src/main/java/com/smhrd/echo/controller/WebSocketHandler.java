package com.smhrd.echo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
@Component
public class WebSocketHandler extends TextWebSocketHandler{
        //HashMap<String, WebSocketSession> sessionMap = new HashMap<>(); //웹소켓 세션을 담아둘 맵
        List<HashMap<String, Object>> rls = new ArrayList<>(); //웹소켓 세션을 담아둘 리스트 ---roomListSessions
        
        @Override
          public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
             System.out.println("message :::::::::::: " + message.getPayload());
             //소켓 연결
             super.afterConnectionEstablished(session);
             boolean flag = false;
             String url = session.getUri().toString();
             System.out.println(url);
             String roomNumber = url.split("/chatting/")[1];
             int idx = rls.size(); //방의 사이즈를 조사한다.
             if(rls.size() > 0) {
                for(int i=0; i<rls.size(); i++) {
                   String rN = (String) rls.get(i).get("roomNumber");
                   if(rN.equals(roomNumber)) {
                      flag = true;
                      idx = i;
                      break;
                   }
                }
             }
             
             if(flag) { //존재하는 방이라면 세션만 추가한다.
                System.out.println("falg true sessionId :::::::::::: " + session.getId());
                HashMap<String, Object> map = rls.get(idx);
                map.put(session.getId(), session);
                
                Iterator<String> keys = map.keySet().iterator();
                while(keys.hasNext()) {
                    String key = keys.next();
                    if (key != null && !"roomNumber".equals(key)) {
                        System.out.println("keys :: " + key);
                        WebSocketSession s = (WebSocketSession) map.get(key);
                        System.out.println("loop send message :: "+ message);
                        //s.sendMessage(message);
                        
                        JSONObject obj = new JSONObject();
                     obj.put("type", "getId");
                     obj.put("sessionId", session.getId());
                     obj.put("message", message.getPayload());
                     System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                     System.out.println(obj.toJSONString());
                     System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                     s.sendMessage(new TextMessage(obj.toJSONString()));
                    }
                }
                
                
             }else { //최초 생성하는 방이라면 방번호와 세션을 추가한다.
                 System.out.println("falg false sessionId :::::::::::: " + session.getId());
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("roomNumber", roomNumber);
                map.put(session.getId(), session);
                rls.add(map);
                
                JSONObject obj = new JSONObject();
                 obj.put("type", "getId");
                 obj.put("sessionId", session.getId());
                 obj.put("message", message.getPayload());
                 session.sendMessage(new TextMessage(obj.toJSONString()));
             }
             //세션등록이 끝나면 발급받은 세션ID값의 메시지를 발송한다.
             /*
             JSONObject obj = new JSONObject();
             obj.put("type", "getId");
             obj.put("sessionId", session.getId());
             obj.put("message", message.getPayload());
             session.sendMessage(new TextMessage(obj.toJSONString()));
             */
          }
        
        @SuppressWarnings("unchecked")
        @Override
        public void afterConnectionEstablished(WebSocketSession session) throws Exception {
            System.out.println("afterConnectionEstablished ::::::::::::::::::::");
            //소켓 연결
            super.afterConnectionEstablished(session);
            boolean flag = false;
            String url = session.getUri().toString();
            System.out.println(url);
            //String roomNumber = url.split("/chating/")[1];
            String roomNumber = "1";
            int idx = rls.size(); //방의 사이즈를 조사한다.
            if(rls.size() > 0) {
                for(int i=0; i<rls.size(); i++) {
                    String rN = (String) rls.get(i).get("roomNumber");
                    if(rN.equals(roomNumber)) {
                        flag = true;
                        idx = i;
                        break;
                    }
                }
            }
            
            if(flag) { //존재하는 방이라면 세션만 추가한다.
                HashMap<String, Object> map = rls.get(idx);
                map.put(session.getId(), session);
                
                for (int i = 0; i < map.size() ; i ++) {
                    //map.get(i);
                    System.out.println("after connection : Map Index :::: " + i);
                }
                
                //int  mapIndex = 0;
                //map.values().forEach(s -> {
                    //try {
                    //  System.out.println("mapIndex :: " + mapIndex);
                        //mapIndex ++;
                    //} catch (Exception e) {
                        
                    //}
                //});
                
            }else { //최초 생성하는 방이라면 방번호와 세션을 추가한다.
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("roomNumber", roomNumber);
                map.put(session.getId(), session);
                rls.add(map);
            }
            
            //세션등록이 끝나면 발급받은 세션ID값의 메시지를 발송한다.
            
            JSONObject obj = new JSONObject();
            obj.put("type", "getId");
            obj.put("roomNumber", roomNumber);
            obj.put("sessionId", session.getId());
            obj.put("chtMessage", "연결됨 ::::::::::::::");
            session.sendMessage(new TextMessage(obj.toJSONString()));
            
        }
        
        @Override
        public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
            System.out.println("afterConnectionClosed ::::::::::::::::::::");
            //소켓 종료
            if(rls.size() > 0) { //소켓이 종료되면 해당 세션값들을 찾아서 지운다.
                for(int i=0; i<rls.size(); i++) {
                    rls.get(i).remove(session.getId());
                }
            }
            super.afterConnectionClosed(session, status);
        }
        
        private static JSONObject jsonToObjectParser(String jsonStr) {
            System.out.println("jsonToObjectParser ::::::::::::::::::::");
            JSONParser parser = new JSONParser();
            JSONObject obj = null;
            try {
                obj = (JSONObject) parser.parse(jsonStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return obj;
        }
}