package com.webank.wedatasphere.linkis.filesystem.restful.api;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Controller
public class BulletController {

    @MessageMapping("/chat")
    @SendTo("/toAll/bulletScreen")             //SendTo 发送至 Broker 下的指定订阅路径
    public String say() {


        return "天生我才必有用";
    }
}
