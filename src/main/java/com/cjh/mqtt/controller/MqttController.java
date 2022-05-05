package com.cjh.mqtt.controller;

import com.cjh.mqtt.util.MqttSendClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mqtt")
public class MqttController {

    @Autowired
    private MqttSendClient MqttSendClient;

    @GetMapping(value = "/publishTopic")
    public Object publishTopic(String sendMessage) {
        System.out.println("message:"+sendMessage);
        sendMessage=sendMessage+" : {\"name\":\"cjh\",\"age\":22}";
//        MqttSendClient.publish(false,"client:report:2",sendMessage);
        MqttSendClient.publish(false ,"testtopic/junhao",sendMessage);
        return null;
    }

    @GetMapping("/test")
    public String test(String str){
        System.out.println("hello test");
        System.out.println(str);
        return "hello test";
    }

    @GetMapping("/test2")
    public String test2(){
        System.out.println("hello test2 ");
        return "hello test2";
    }
}

