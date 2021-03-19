package com.mystudy.stream.service.impl;

import com.mystudy.stream.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author 刘健生
 * @Date 2021-03-19 17:56
 * @Description
 */
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;


    @Override
    public String send() {
        String uid = UUID.randomUUID().toString();
        Message<String> message = MessageBuilder.withPayload(uid).build();
        output.send(message);
        return uid;
    }
}
