package com.study.learnspringboot.controller;

import netscape.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebController {

    @Autowired//发送装置(从服务器发送到浏览器)
    private SimpMessagingTemplate template;

    @MessageMapping("/chat")
    public void handleChat(Principal principal, String msg){
        if (principal.getNickname().equals("wxj")){
            template.convertAndSendToUser("wxj_admin",
                    "/queue/notification", principal.getNickname()+"-send:"+msg);
        }else{
            template.convertAndSendToUser("wxj",
                    "/queue/notification", principal.getNickname()+"-send:"+msg);
        }
    }
}
