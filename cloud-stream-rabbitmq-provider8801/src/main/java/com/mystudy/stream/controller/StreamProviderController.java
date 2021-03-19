package com.mystudy.stream.controller;

import com.mystudy.stream.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author 刘健生
 * @Date 2021-03-19 18:01
 * @Description
 */
@RestController
public class StreamProviderController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return messageProvider.send();
    }

}
